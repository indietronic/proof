package java.com.editor;


import java.beans.PropertyEditorSupport;
import java.com.entities.DipartimentoEntity;


public class DipartimentoEditor extends PropertyEditorSupport 
{
    @Override
    public void setAsText(String id){
    	DipartimentoEntity d;
    	switch(Integer.parseInt(id)){
			case 1: d = new DipartimentoEntity(1,  "Human Resource"); 
				break;
			case 2: d = new DipartimentoEntity(2,  "Finance"); 
				break;
			case 3: d = new DipartimentoEntity(3,  "Information Technology");
				break;
			default: d = null;
		}
        this.setValue(d);
    }
}
