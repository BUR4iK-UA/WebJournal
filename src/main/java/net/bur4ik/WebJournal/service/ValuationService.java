package net.bur4ik.WebJournal.service;


import net.bur4ik.WebJournal.model.Valuation;

import java.util.List;

public interface ValuationService {
    void addValuation(Valuation valuation);
    void saveValuation(Valuation valuation);
    void updateValuation(Valuation valuation);
    Valuation getValuationById(int idVal);
    List<Valuation> getListValuation();
    List<Valuation> getListValuationsByIdSubject(int idSubject);
    List<Valuation> getListValByIdStudentAndIdSubject(int idStudent, int idSubject);

}
