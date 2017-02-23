package controller;

import model.Original1Model;
import model.Original2Model;
import model.Original3Model;
import model.Original4Model;
import model.Original5Model;
import model.Original6Model;
import model.Original7Model;
import view.*;

public class OriginalController {
    private OriginalView appView;
    private static OriginalController firstInstance = null;
    
    private OriginalController() {
        appView = new OriginalView(this);
    }
    
    public static OriginalController getInstance(){
        if(firstInstance == null)
            firstInstance = new OriginalController();       
        
        return firstInstance;
    }
    
    public void updateQuery1Tables(){
        appView.updateQuery1Tables(Original1Model.getAllOfw(), Original1Model.getAllNonOfw());
    }
    
    public void updateQuery1Details(){
        appView.updateQuery1Details(Original1Model.getAllOfwTime(),
                                    Original1Model.getAllNonOfwTime(),
                                    Original1Model.getStrongOfwAverage(),
                                    Original1Model.getWeakOfwAverage(),
                                    Original1Model.getStrongNonOfwAverage(),
                                    Original1Model.getWeakNonOfwAverage());
    }
    
    public void updateQuery2Tables(int age, int educind, int jobind){
        appView.updateQuery2Tables(Original2Model.getResult(age, educind, jobind));
    }
    
    public void updateQuery2Details(int age, int educind, int jobind){
        appView.updateQuery2Details(Original2Model.getResultTime(age, educind, jobind),
                                    Original2Model.getAverage(age, 2, 1),
                                    Original2Model.getAverage(age, 1, 2),
                                    Original2Model.getAverage(age, 2, 2));
    }
    
    public void updateQuery3Tables(){
        appView.updateQuery3Tables(Original3Model.getOfwMaids(), Original3Model.getNonOfwMaids());
    }
    
    public void updateQuery3Details(){
        appView.updateQuery3Details(Original3Model.getOfwMaidsTime(),
                                    Original3Model.getNonOfwMaidsTime(),
                                    Original3Model.getOfwMaidAverage(),
                                    Original3Model.getNonOfwMaidAverage());
    }
    
    public void updateQuery4Tables(int calam, int frequency){
        appView.updateQuery4Tables(Original4Model.getResult(calam, frequency));
    }
    
    public void updateQuery4Details(int calam, int frequency){
        appView.updateQuery4Details(Original4Model.getResultTime(calam, frequency),
                                    Original4Model.getAverage(calam, frequency));
    }
    
    public void updateQuery5Tables(){
        appView.updateQuery5Tables(Original5Model.getResult());
    }
    
    public void updateQuery5Details(){
        appView.updateQuery5Details(Original5Model.getResultTime(),
                                    Original5Model.getStrongAverage(),
                                    Original5Model.getWeakAverage());
    }
    
    public void updateQuery6Tables(){
        appView.updateQuery6Tables(Original6Model.getOfwCrops(),
                                   Original6Model.getNonOfwCrops());
    }
    
    public void updateQuery6Details(){
        appView.updateQuery6Details(Original6Model.getOfwCropsTime(),
                                    Original6Model.getNonOfwCropsTime(),
                                    Original6Model.getOfwAvg(),
                                    Original6Model.getNonOfwAvg());
    }
    
    public void updateQuery7Tables(){
        appView.updateQuery7Tables(Original7Model.getResult());
    }
    
    public void updateQuery7Details(){
        appView.updateQuery7Details(Original7Model.getResultTime(),
                                    Original7Model.getTotal(),
                                    Original7Model.getCshWrkSum(),
                                    Original7Model.getFudWrkSum(),
                                    Original7Model.getFudSchSum());
    }
}
