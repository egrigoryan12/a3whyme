package com.mycompany.a3;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.UITimer;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;

public class Game extends Form implements Runnable {
	
	private GameWorld gw;
	private MapView mv;
	private ScoreView sv; 
	private UITimer timer;

	
	public Game(){
		
		gw = new GameWorld(); 
		mv = new MapView(gw); 
		sv = new ScoreView(gw); 
		gw.addObserver(mv); 
		gw.addObserver(sv); 
		setTitleBar();
		
		
		timer = new UITimer(this);
		timer.schedule(1000, true, this);

		
		
		
		
		
		setLayout(new BorderLayout());
		BorderLayoutForm borderLayoutForm = new BorderLayoutForm();
	    add(BorderLayout.CENTER, borderLayoutForm);
	    
	    Container scoreViewContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        scoreViewContainer.add(sv);
        add(BorderLayout.NORTH, scoreViewContainer);
        
		Toolbar myToolbar = new Toolbar();
		setToolbar(myToolbar);
		
		//Red Border
		Container redContainer = new Container();
        redContainer.getAllStyles().setBgTransparency(0);
        Border redBorder = Border.createLineBorder(5, 0xFF0000); 
        redContainer.getAllStyles().setBorder(redBorder);
        borderLayoutForm.add(BorderLayout.CENTER, redContainer);

//Sidebar Menu - Accelerate, Sound, About, Exit
		
		//Accelerate Command 
		Command accelerateCommand = new AccelerateCommand(gw);
		myToolbar.addCommandToSideMenu(accelerateCommand);
		
		//Sound Command
		Command sideMenuItem2 = new Command("Sound");
		myToolbar.addCommandToSideMenu(sideMenuItem2);
		CheckBox soundCheckBox = new CheckBox();
		soundCheckBox.setSelected(gw.isSoundOn());
		soundCheckBox.addActionListener(e -> gw.toggleSound()); 
		myToolbar.addComponentToSideMenu(soundCheckBox);;
		
		//About Command
        AboutCommand aboutCommand = new AboutCommand();
        myToolbar.addCommandToSideMenu(aboutCommand);

		//Exit Command
        ExitCommand exitCommand = new ExitCommand();
        myToolbar.addCommandToSideMenu(exitCommand);
		
//Titlebar - Title, Help
		
        //Title
        Label title = new Label("TheJourney Game", "Title");
        title.getAllStyles().setFgColor(0x000000); 
        title.getAllStyles().setAlignment(Component.CENTER);
        myToolbar.setTitleComponent(title);

		//Help
		HelpCommand titleBarAreaItem2 = new HelpCommand();
		myToolbar.addCommandToRightBar(titleBarAreaItem2);

		this.show();
		
		
		gw.init();
		// Key Listeners for Commands
		 addKeyListener('a',new ActionListener() {
       	  public void actionPerformed(ActionEvent e) {
       	        gw.accelerate();
       }
		 });
		 
		 addKeyListener('b',new ActionListener() {
	       	  public void actionPerformed(ActionEvent e) {
	       	        gw.brake();
	       }
			 });
		 
		 addKeyListener('l',new ActionListener() {
	       	  public void actionPerformed(ActionEvent e) {
	       	        gw.l();
	       }
			 });
		 
		 addKeyListener('r',new ActionListener() {
	       	  public void actionPerformed(ActionEvent e) {
	       	        gw.r();
	       }
			 });
		 addKeyListener('f',new ActionListener() {
	       	  public void actionPerformed(ActionEvent e) {
	       	        gw.handleCollisionWithFoodStation();
	       }
			 });
		 addKeyListener('g',new ActionListener() {
	       	  public void actionPerformed(ActionEvent e) {
	       	        gw.handleCollisionWithSpider();
	       }
			 });
		 addKeyListener('t',new ActionListener() {
	       	  public void actionPerformed(ActionEvent e) {
	       	        gw.tick();
	       }
			 });
		 addKeyListener((char) 0, new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        System.out.println("Invalid command. Please try again.");
			    }
			});
		 
}

	private void setTitleBar() {
		
	}

	public class BorderLayoutForm extends Form {
	    public BorderLayoutForm() {
	        this.setLayout(new BorderLayout());
	        
	        Container westContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
	        Container eastContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
	        Container southContainer = new Container(new FlowLayout(Component.CENTER));
	        
	        Style button = new Style();
	        button.setBgColor(ColorUtil.BLUE);
	        button.setFgColor(ColorUtil.WHITE);
	        
	    //West Border
	        //Accelerate
	        Button leftSide = new Button("Accelerate");
	        leftSide.setUnselectedStyle(button);
	        leftSide.getUnselectedStyle().setPadding(20,20,20,20);
	        leftSide.getAllStyles().setBorder(Border.createLineBorder(1,ColorUtil.BLACK));
	        AccelerateCommand accelerateCommand = new AccelerateCommand(gw);
	        leftSide.setCommand(accelerateCommand);
	        
	       

	        Button leftSide2 = new Button("Left");
	        leftSide2.setUnselectedStyle(button);
	        leftSide2.getUnselectedStyle().setPadding(20,20,20,20);
	        leftSide2.getAllStyles().setBorder(Border.createLineBorder(1,ColorUtil.BLACK));
	        LeftTurnCommand leftTurn = new LeftTurnCommand(gw);
	        leftSide2.setCommand(leftTurn);
	        
	        westContainer.add(leftSide);
	        westContainer.add(leftSide2);
	
	    // East Border
	        Button rightSide = new Button("Break");
	        rightSide.setUnselectedStyle(button);
	        rightSide.getUnselectedStyle().setPadding(20,20,20,20);
	        rightSide.getAllStyles().setBorder(Border.createLineBorder(1,ColorUtil.BLACK));
	        BrakeCommand brakeCommand = new BrakeCommand(gw);
	        rightSide.setCommand(brakeCommand);
	        
	        Button rightSide2 = new Button("Right");
	        rightSide2.setUnselectedStyle(button);
	        rightSide2.getUnselectedStyle().setPadding(20,20,20,20);
	        rightSide2.getAllStyles().setBorder(Border.createLineBorder(1,ColorUtil.BLACK));
	        RightTurnCommand rightTurn = new RightTurnCommand(gw);
	        rightSide2.setCommand(rightTurn);

	        eastContainer.add(rightSide);
	        eastContainer.add(rightSide2);
	        
	        
	    // South Border
	        Button botton = new Button("Position");
	        botton.setUnselectedStyle(button);
	        botton.getUnselectedStyle().setPadding(20,20,20,20);
	        botton.getAllStyles().setBorder(Border.createLineBorder(1,ColorUtil.BLACK));
	        FlagCollisionCommand collideFlag = new FlagCollisionCommand(gw);
	        botton.setCommand(collideFlag);
	        
	      
	        
	        Button botton4 = new Button("Tick");
	        botton4.setUnselectedStyle(button);
	        botton4.getUnselectedStyle().setPadding(20,20,20,20);
	        botton4.getAllStyles().setBorder(Border.createLineBorder(1,ColorUtil.BLACK));
	        TickCommand tick = new TickCommand(gw);
	        botton4.setCommand(tick);
	        
	        southContainer.add(botton);
	      
	        southContainer.add(botton4);
	         
	     //Border Options
	  	    this.add(BorderLayout.WEST, westContainer);
	        this.add(BorderLayout.EAST, eastContainer);
	        this.add(BorderLayout.SOUTH, southContainer);

	    }

}

	@Override
	public void run() {
		gw.tick();
	}

	public UITimer getTimer() {
		return timer;
	}

	public void setTimer(UITimer timer) {
		this.timer = timer;
	}
	
	 public void exit() {
		 	gw.exit();
	        // Stop the timer
	        timer.cancel();
	    }
}


//comm







