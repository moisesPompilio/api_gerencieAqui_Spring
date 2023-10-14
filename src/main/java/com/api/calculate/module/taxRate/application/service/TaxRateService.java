package com.api.calculate.module.taxRate.application.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import jakarta.annotation.Resource;

import org.springframework.stereotype.Service;

import com.api.calculate.module.taxRate.domain.entity.RateTimeline;
import com.api.calculate.module.taxRate.domain.entity.TaxRate;
import com.api.calculate.module.tax_name.application.service.TaxNameService;
import com.api.calculate.module.tax_name.domain.entity.TaxName;
import com.api.calculate.shared.core.generic.crud.repository.GenericRepository;
import com.api.calculate.shared.core.generic.crud.service.GenericService;
import com.api.calculate.shared.exception.NegocioException;

@Service
public class TaxRateService extends GenericService<TaxRate> {

    @Resource
    private TaxNameService taxNameService;

    public TaxRateService(GenericRepository<TaxRate, UUID> repository) {
        super(repository);
    }

    @Override
    public TaxRate salvar(TaxRate taxRate) {
        validation(taxRate);
        return super.salvar(taxRate);
    }

    @Override
    public List<TaxRate> salvarLista(List<TaxRate> listTaxRate) {
        for (TaxRate taxRate : listTaxRate) {
            validation(taxRate);
        }
        return super.salvarLista(listTaxRate);
    }

    protected void validation (TaxRate taxRate) {
        if (taxRate.getRateTimeline().isEmpty()){
            throw new NegocioException("É obrigatório informa os períodos das taxas");
        }
        LocalDate datePredecessor = taxRate.getRateTimeline().get(0).getEndDate();

        for ( RateTimeline rateTimeline : taxRate.getRateTimeline()) {
            TaxName taxName = taxNameService.buscar(rateTimeline.getTaxNameID().toString());

            if ( rateTimeline.getStartDate().isAfter(rateTimeline.getEndDate()) ) {

                String message = "A taxa " + taxName.getName() + " está incorreta. " +
                     "O inicio da taxa não podem ser posterior ao final" ;
                throw new NegocioException(message);

            } else if ( rateTimeline.getStartDate().equals(rateTimeline.getEndDate()) ) {

                String message = "A taxa " + taxName.getName() + " está incorreta. " +
                     "As datas de inicio e final não podem ser igual";
                throw new NegocioException(message);
            }

            if ( datePredecessor.isAfter(rateTimeline.getStartDate() ) || datePredecessor.equals(rateTimeline.getStartDate()) ) {
                String message = "A taxa " + taxName.getName() + " está incorreta. " +
                     "Ela não pode iniciar antes do termino da sua antecessora ou no mesmo dia";
                throw new NegocioException(message);
            }

            datePredecessor = rateTimeline.getEndDate();
        }
        return;
    }


}
