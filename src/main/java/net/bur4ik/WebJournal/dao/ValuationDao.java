package net.bur4ik.WebJournal.dao;


import net.bur4ik.WebJournal.model.Valuation;

import java.sql.Date;
import java.util.List;

public interface ValuationDao {
    void addValuation(Valuation valuation);
    void saveValuation(Valuation valuation);
    void updateValuation(Valuation valuation);
    Valuation getValuationById(int idVal);
    //void updateValuation(Valuation valuation);
   // void revomeValuation(int idValuation);
    List<Valuation> getListValuations();
    List<Valuation> getListValuationsByIdSubject(int idSubject);
    List<Valuation> getListValByIdStudentAndIdSubject(int idStudent, int idSubject);
    //List<Valuation> getListValByIdStudentAndDatePeriod(int idStudent, Date begin, Date end);
}
