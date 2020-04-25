package org.cap.controller;

import java.util.List;

import org.cap.dao.TraineeDaoImpl;
import org.cap.entities.*;
import org.cap.service.ITraineeService;
import org.cap.service.TraineeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import org.cap.entities.Admin;
import org.cap.session.SessionDetails;

@Controller
public class HelloController {

    private ITraineeService traineeService;

    public ITraineeService getTraineeService(){
        return traineeService;
    }
    @Autowired
    public void setTraineeService(ITraineeService service){
        this.traineeService=service;
    }

    @Autowired
    private SessionDetails sessionDetails;   
    
    @Autowired
    private Admin admin;  //admin credentials the entity class for admin is made for that
    public boolean credentialsCorrect(int id, String password) {
        boolean flag=false;
    	if (password == null || password.isEmpty()) {
            return false;
        }
    	if(id==admin.getId()&&password.equals(admin.getPassword())) {
    	    flag= true;
        }
    return flag;
    }
    @GetMapping("/processlogin")
    public ModelAndView login(@RequestParam("id")int id , @RequestParam("password") String password){
        boolean correct=credentialsCorrect(id,password);
        if(!correct){
         return new ModelAndView("/login");
        }
        sessionDetails.setId(id);
        ModelAndView modelAndView= new ModelAndView("traineeHome");
        return modelAndView;
    }
    
    @GetMapping("/hello")
    //@RequestMapping(method = {RequestMethod.GET}, value = "/hello")
    public ModelAndView sayHello() {
        return new ModelAndView("hellopage",  "message", "Welcome user");
    }

    @GetMapping("/add")
    public ModelAndView addtrainee() {
    	int id=sessionDetails.getId();
        if(id==-1){
         return new ModelAndView("/login");
        }
        return new ModelAndView("addtrainee");
    }


    @GetMapping("/processaddtrainee")
    public ModelAndView traineeDetails(@RequestParam("traineeId")int traineeId,@RequestParam("traineeName")String traineeName
    		,@RequestParam("traineeDomain")String traineeDomain,@RequestParam("traineeLocation")String traineeLocation) {
        Trainee t=new Trainee(traineeId,traineeName,traineeDomain,traineeLocation);
    	Trainee trainee=getTraineeService().AddTrainee(t);
        return new ModelAndView("traineedetail", "trainee", trainee);
    }


    @GetMapping("/remove")
    public ModelAndView removetrainee() {
    	int id=sessionDetails.getId();
        if(id==-1){
         return new ModelAndView("/login");
        }
    	return new ModelAndView("removetrainee","trainee","trainee");
    }
    @GetMapping("/delete")
    public ModelAndView deletetrainee(@RequestParam("traineeId")int traineeId) {
    	Trainee trainee=traineeService.deleteTrainee(traineeId);
    	return new ModelAndView("deletetrainee");
    	
    }
    @GetMapping("/modify")
    public ModelAndView modifyTrainee() {
    	int id=sessionDetails.getId();
        if(id==-1){
         return new ModelAndView("/login");
        }
    	return new ModelAndView("modify");
    }
    
    @GetMapping("/preocessmodifytrainee")
    public ModelAndView processModify(@RequestParam("traineeId")int traineeId,@RequestParam("traineeName")String traineeName
    		,@RequestParam("traineeDomain")String traineeDomain,@RequestParam("traineeLocation")String traineeLocation) {
    	Trainee trainee=new Trainee();
    	Trainee traine=traineeService.modifyTrainee(trainee);
    	return new ModelAndView("modifyDetails");
    }
    
    @GetMapping("/find")
    public ModelAndView findTrainee() {
    	int id=sessionDetails.getId();
        if(id==-1){
         return new ModelAndView("/login");
        }
    	return new ModelAndView("findTraineeById");
    }
    @GetMapping("/retrieveTrainee")
    public ModelAndView retrieveTrainee(@RequestParam("traineeId")int traineeId) {
    	Trainee trainee=traineeService.retrieveTrainee(traineeId);
    	return new ModelAndView("retrievaltrainee"); 
    }
    @GetMapping("/findAll")
    public ModelAndView findAllTrainee() {
    	int id=sessionDetails.getId();
        if(id==-1){
         return new ModelAndView("/login");
        }
    	List<Trainee> trainee=traineeService.retrieveAllTrainee();
    	return new ModelAndView("allTrainee");
    }
    @GetMapping("/")
    public ModelAndView home(){
        return new ModelAndView("traineeHome");
    }

    @GetMapping("/logout")
    public ModelAndView logout(){
        sessionDetails.setId(-1);
        return new ModelAndView("/login");
    }
}







