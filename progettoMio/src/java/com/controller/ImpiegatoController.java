package java.com.controller;

import java.com.editor.DipartimentoEditor;
import java.com.entities.DipartimentoEntity;
import java.com.entities.ImpiegatoEntity;
import java.com.services.ImpiegatoManager;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/employee-module")
@SessionAttributes("employee")
public class ImpiegatoController {
	
	@Autowired
	ImpiegatoManager impiegatoManager;
	
	private Validator validator;

	public ImpiegatoController(){
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		validator =  validatorFactory.getValidator();
	}
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(DipartimentoEntity.class, new DipartimentoEditor());
    }
	
	@ModelAttribute("allDipartimenti")
    public List<DipartimentoEntity> populateDipartimenti() {
        List<DipartimentoEntity> departments = impiegatoManager.getAllDipartimenti();
        return departments;
    }
     
    @ModelAttribute("allImpiegati")
    public List<ImpiegatoEntity> populateImpiegati() {
        List<ImpiegatoEntity> employees = impiegatoManager.getAllImpiegati();
        return employees;
    }
    
    /**
     * Method will be called in initial page load at GET /employee-module
     * */
    @RequestMapping(method = RequestMethod.GET)
    public String setupForm(Model model) {
        ImpiegatoEntity employeeVO = new ImpiegatoEntity();
        model.addAttribute("impiegato", employeeVO);
        return "listEmployeeView";
    }
    
    /**
     * Method will be called on submitting add employee form POST /employee-module
     * */
    @RequestMapping(method = RequestMethod.POST)
    public String submitForm(@ModelAttribute("employee") ImpiegatoEntity employeeVO,
            BindingResult result, SessionStatus status) {
 
        Set<ConstraintViolation<ImpiegatoEntity>> violations = validator.validate(employeeVO);
         
        for (ConstraintViolation<ImpiegatoEntity> violation : violations){
            String propertyPath = violation.getPropertyPath().toString();
            String message = violation.getMessage();
            // Add JSR-303 errors to BindingResult
            // This allows Spring to display them in view via a FieldError
            result.addError(new FieldError("impiegato", propertyPath, "Invalid "+ propertyPath + "(" + message + ")"));
        }
 
        if (result.hasErrors()) {
            return "listEmployeeView";
        }
        // Store the employee information in database
        impiegatoManager.addEmployee(employeeVO);
         
        // Mark Session Complete and redirect to URL so that page refresh do not re-submit the form
        status.setComplete();
        return "redirect:employee-module";
    }
}
