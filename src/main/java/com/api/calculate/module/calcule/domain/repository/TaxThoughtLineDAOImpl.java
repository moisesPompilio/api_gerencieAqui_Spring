package com.api.calculate.module.calcule.domain.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.api.calculate.module.calcule.application.models.TaxThoughtLine;
import com.api.calculate.module.taxRate.domain.entity.TaxRate;
import com.api.calculate.shared.util.alias.TableAlias;
import com.api.calculate.shared.util.query.Column;
import com.api.calculate.shared.util.query.ColumnType;
import com.api.calculate.shared.util.query.Condition;
import com.api.calculate.shared.util.query.Join;
import com.api.calculate.shared.util.query.Operator;
import com.api.calculate.shared.util.query.Order;
import com.api.calculate.shared.util.query.OrderType;
import com.api.calculate.shared.util.query.Select;
import com.api.calculate.shared.util.query.Table;
import com.api.calculate.shared.util.query.Where;

@Repository
public class TaxThoughtLineDAOImpl implements TaxThoughtLineDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings( "unchecked" )
    @Override
    public List< TaxThoughtLine > findByTaxRate ( TaxRate taxRate ) {
        Table taxTable = new Table(TableAlias.TAX_NAME, TableAlias.TAX_ALIAS);

        Table taxNameTable = new Table(TableAlias.TAX_NAME_NAME, TableAlias.TAX_NAME_ALIAS);
        Join joinTaxName = new Join(taxNameTable, TableAlias.TAX_ALIAS + ".tax_name_id",  TableAlias.TAX_NAME_ALIAS + ".id");
        taxTable.join(joinTaxName);

        Column dataColumn = taxTable.getColumn("data", ColumnType.DATE);
        Column percentualColumn = taxTable.getColumn("percentual", ColumnType.NUMBER);
        Column nameColumn = taxNameTable.getColumn("name", ColumnType.TEXT);

        Order order = new Order(dataColumn.getName(), OrderType.DESC);

        Where where = new Where();

        Column columnTaxNameId =  taxNameTable.getColumn("id", ColumnType.TEXT);
        taxRate.getRateTimeline().forEach( rateTimeline -> {
            Condition conditionEqualId = new Condition( columnTaxNameId , Operator.EQUAL, rateTimeline.getTaxNameID().toString());

            Map<String, Object> dateRange = new HashMap<>();
            dateRange.put("initial", rateTimeline.getStartDate().toString());
            dateRange.put("final", rateTimeline.getEndDate().toString());
            Condition conditionBetweenDates = new Condition( dataColumn, Operator.BETWEEN, dateRange );

            Condition queryCondition = new Condition(conditionEqualId, conditionBetweenDates);
            where.add(queryCondition);
        } );

        Select select = new Select();
        select.table(taxTable)
            .addColumns(dataColumn, percentualColumn, nameColumn)
            .where(where)
            .order(order);
        String sql = select.toQuery();

        return entityManager.createNativeQuery(sql, TaxThoughtLine.class).getResultList();
    }

}
