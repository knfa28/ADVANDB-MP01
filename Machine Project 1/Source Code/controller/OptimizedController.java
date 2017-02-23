package controller;

import model.Original1Model;
import model.Original2Model;
import model.Original3Model;
import model.Original4Model;
import model.Original5Model;
import model.Original6Model;
import model.Original7Model;
import model.Optimized1Model;
import model.Optimized2Model;
import model.Optimized3Model;
import model.Optimized5Model;
import model.Optimized6Model;
import model.Optimized4Model;
import model.Optimized7Model;
import view.*;

public class OptimizedController {
    private OptimizedView appView;
    private static OptimizedController firstInstance = null;
    
    private OptimizedController() {
        appView = new OptimizedView(this);
    }
    
    public static OptimizedController getInstance(){
        if(firstInstance == null)
            firstInstance = new OptimizedController();       
        
        return firstInstance;
    }
    
    public void updateQuery1Tables(){
        appView.updateQuery1Tables(Optimized1Model.getAllOfw(), Optimized1Model.getAllNonOfw());
    }
    
    public void updateQuery1Details(){
        appView.updateQuery1Details(Optimized1Model.getAllOfwTime(),
                                   Optimized1Model.getAllNonOfwTime(),
                                   Optimized1Model.getStrongOfwAverage(),
                                   Optimized1Model.getWeakOfwAverage(),
                                   Optimized1Model.getStrongNonOfwAverage(),
                                   Optimized1Model.getWeakNonOfwAverage());
    }
    
    public void updateQuery2Tables(int age, int educind, int jobind){
        appView.updateQuery2Tables(Optimized2Model.getResult(age, educind, jobind));
    }
    
    public void updateQuery2Details(int age, int educind, int jobind){
        appView.updateQuery2Details(Optimized2Model.getResultTime(age, educind, jobind),
                                    Optimized2Model.getAverage(age, 2, 1),
                                    Optimized2Model.getAverage(age, 1, 2),
                                    Optimized2Model.getAverage(age, 2, 2));
    }
    
    public void updateQuery3Tables(){
        appView.updateQuery3Tables(Optimized3Model.getOfwMaids(), Optimized3Model.getNonOfwMaids());
    }
    
    public void updateQuery3Details(){
        appView.updateQuery3Details(Optimized3Model.getOfwMaidsTime(),
                                    Optimized3Model.getNonOfwMaidsTime(),
                                    Optimized3Model.getOfwMaidAverage(),
                                    Optimized3Model.getNonOfwMaidAverage());
    }
    
    public void updateQuery4Tables(int calam, int frequency){
        appView.updateQuery4Tables(Optimized4Model.getResult(calam, frequency));
    }
    
    public void updateQuery4Details(int calam, int frequency){
        appView.updateQuery4Details(Optimized4Model.getResultTime(calam, frequency),
                                    Optimized4Model.getAverage(calam, frequency));
    }
    
    public void updateQuery5Tables(){
        appView.updateQuery5Tables(Optimized5Model.getResult());
    }
    
    public void updateQuery5Details(){
        appView.updateQuery5Details(Optimized5Model.getResultTime(),
                                    Optimized5Model.getStrongAverage(),
                                    Optimized5Model.getWeakAverage());
    }
    
    public void updateQuery6Tables(){
        appView.updateQuery6Tables(Optimized6Model.getOfwCrops(),
                                   Optimized6Model.getNonOfwCrops());
    }
    
    public void updateQuery6Details(){
        appView.updateQuery6Details(Optimized6Model.getOfwCropsTime(),
                                    Optimized6Model.getNonOfwCropsTime(),
                                    Optimized6Model.getOfwAvg(),
                                    Optimized6Model.getNonOfwAvg());
    }
    
    public void updateQuery7Tables(){
        appView.updateQuery7Tables(Optimized7Model.getResult());
    }
    
    public void updateQuery7Details(){
        appView.updateQuery7Details(Optimized7Model.getResultTime(),
                                    Optimized7Model.getTotal(),
                                    Optimized7Model.getCshWrkSum(),
                                    Optimized7Model.getFudWrkSum(),
                                    Optimized7Model.getFudSchSum());
    }
}
