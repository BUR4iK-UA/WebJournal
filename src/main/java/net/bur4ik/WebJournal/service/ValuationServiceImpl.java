package net.bur4ik.WebJournal.service;

import net.bur4ik.WebJournal.dao.ValuationDao;
import net.bur4ik.WebJournal.model.Valuation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ValuationServiceImpl implements ValuationService{

    private ValuationDao valuationDao;

    public void setValuationDao(ValuationDao valuationDao) {
        this.valuationDao = valuationDao;
    }

    @Override
    @Transactional
    public void addValuation(Valuation valuation) {
        valuationDao.addValuation(valuation);
    }

    @Override
    @Transactional
    public void saveValuation(Valuation valuation) {
        valuationDao.saveValuation(valuation);
    }

    @Override
    @Transactional
    public void updateValuation(Valuation valuation) {
        valuationDao.updateValuation(valuation);
    }

    @Override
    @Transactional
    public Valuation getValuationById(int idVal) {
        return valuationDao.getValuationById(idVal);
    }

    @Override
    @Transactional
    public List<Valuation> getListValuation() {
        return valuationDao.getListValuations();
    }

    @Override
    @Transactional
    public List<Valuation> getListValuationsByIdSubject(int idSubject) {
        return valuationDao.getListValuationsByIdSubject(idSubject);
    }

    @Override
    @Transactional
    public List<Valuation> getListValByIdStudentAndIdSubject(int idStudent, int idSubject) {
        return valuationDao.getListValByIdStudentAndIdSubject(idStudent, idSubject);
    }
}
