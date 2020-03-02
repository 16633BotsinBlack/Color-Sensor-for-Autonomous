package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import android.graphics.Color;


@Autonomous(name="16633: Auto Load Sample Template Side Not Specified", group="16633")
//@Disabled
public class Auto_Load_Sample_Template_Side_Not_Specified extends LinearOpMode {

    /* Declare OpMode members. */
    MaristBaseRobot2019_Quad_14101 robot   = new MaristBaseRobot2019_Quad_14101();   
    private ElapsedTime runtime = new ElapsedTime();
    
    // Variables to control Speed
    double velocity = 0.5; // Default velocity
    
    ColorSensor sensorColorRight; // i2c Port 1
    ColorSensor sensorColorLeft;  // i2c Port 0

    @Override
    public void runOpMode() {
        
        // hsvValues is an array that will hold the hue, saturation, and value information.
        float hsvValues[] = {0F, 0F, 0F};

        // values is a reference to the hsvValues array.
        final float values[] = hsvValues;

        // sometimes it helps to multiply the raw RGB values with a scale factor
        // to amplify/attentuate the measured values.
        final double SCALE_FACTOR = 255;


        /*
         * Initialize the drive system variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);
        
        // get a reference to the color sensor.
        sensorColorRight = hardwareMap.get(ColorSensor.class, "color_sensor_right");
        sensorColorLeft = hardwareMap.get(ColorSensor.class, "color_sensor_left");
        

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // Perform the steps of Autonomous One Step at a Time.
        // MARIST: Add Code here!
        // Available Calls: forward(inches),delay(seconds),right(degrees),left(degrees)
    // robot.leftHand.setPosition(), robot.rightHand.setPosition()
        forward(33);
        delay(0.5);
        
        
        /*  COLOR SENSOR CODE */
        
        // Measure Skystone 1
        Color.RGBToHSV((int) (sensorColorLeft.red() * SCALE_FACTOR),
            (int) (sensorColorLeft.green() * SCALE_FACTOR),
                (int) (sensorColorLeft.blue() * SCALE_FACTOR),
                hsvValues);
                    
        double leftred = sensorColorLeft.red() + sensorColorLeft.green();
        
        // Measure Skystone 2
        Color.RGBToHSV((int) (sensorColorRight.red() * SCALE_FACTOR),
            (int) (sensorColorRight.green() * SCALE_FACTOR),
                (int) (sensorColorRight.blue() * SCALE_FACTOR),
                hsvValues);
                    
        double rightred = sensorColorRight.red() + sensorColorRight.green();
        
        int position = 1;
        

        
        //delay(10);
        
        if(leftred > 150 && rightred > 150)
        {
            position = 3;
            telemetry.addData("Position", position);
            telemetry.addData("Left", leftred);
            telemetry.addData("Right", rightred);
            telemetry.update();
            getPositionThree();
        }
        else if(leftred < rightred) 
        {
            position = 1;
            telemetry.addData("Position", position);
            telemetry.addData("Left", leftred);
            telemetry.addData("Right", rightred);
            telemetry.update();
            getPositionOne();
        }
        else
        {
            position = 2;
            telemetry.addData("Position", position);
            telemetry.addData("Left", leftred);
            telemetry.addData("Right", rightred);
            telemetry.update();
            getPositionTwo();
        }
        

        
        /* COLOR SENSOR CODE FINISHED */
        
        // Autonomous Finished
        telemetry.addData("Path", "Complete");
        telemetry.update();
        //sleep(1000);
    }

    // Functions for REACH 2019 based on Python Turtles
    public void forward(double inches)
    {
        robot.driveStraightInches(velocity, inches, 10);
    }
    
    public void right(double degrees)
    {
        robot.pointTurnDegrees(velocity, degrees, 10);
    }
    
    public void left(double degrees)
    {
        degrees = degrees * -1;
        robot.pointTurnDegrees(velocity, degrees, 10);
    }
    
    public void speed(int speed)
    {
        double newSpeed = (double)speed / 10.0;
        velocity = newSpeed;
    }
    
    // Sample Delay Code
    public void delay(double t) { // Imitates the Arduino delay function
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < t)) {
            //telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            //telemetry.update();
        }
    }

    
    /* START OF COLOR SENSOR FUNCTIONS */
    
    public void getPositionOne()
    {
      robot.strafeInches(0.8, -3, 2); 
      robot.leftHand.setPosition(0);
      delay(2);
      forward(-5);
      right(-90);
      forward(40);
      robot.leftHand.setPosition(.3);
      forward(-64);
      right(90);
      forward(10);
      robot.leftHand.setPosition(0);
      forward(-10);
      right(-90);
      forward(64);
      robot.leftHand.setPosition(.3);
      forward(-15);
      robot.leftHand.setPosition(.3);
      robot.strafeInches(0.8, 7, 2);
      
    }
    
    public void getPositionTwo()
    {
        robot.strafeInches(0.8, 5, 1); 
        robot.leftHand.setPosition(0);
        delay(0.5);
        forward(-5);
        right(-90);
        forward(50);
        robot.leftHand.setPosition(.3);
        delay(0.5);
        forward(-75);
        right(90);
        forward(15);
        robot.leftHand.setPosition(0);
        delay(0.5);
        forward(-15);
        right(-90);
        forward(75);
        robot.leftHand.setPosition(.3);
        delay(0.5);
        forward(-15);
        robot.leftHand.setPosition(.3);
        robot.strafeInches(0.8, 7, 2);
    }
    
    public void getPositionThree()
    {
        robot.strafeInches(0.8, 11, 1); 
        robot.leftHand.setPosition(0);
        delay(0.5);
        forward(-5);
        right(-90);
        forward(58);
        robot.leftHand.setPosition(.3);
        delay(0.5);
        forward(-70);
        right(90);
        robot.strafeInches(0.8, 10, 1);
        forward(15);
        robot.leftHand.setPosition(0);
        delay(0.5);
        forward(-17);
        robot.strafeInches(0.8, -5, 1);
        right(-95);
        forward(70);
        robot.leftHand.setPosition(.3);
        delay(0.5);
        forward(-15);
        robot.leftHand.setPosition(.3);
        robot.strafeInches(0.8, 7, 2);
    }

}
