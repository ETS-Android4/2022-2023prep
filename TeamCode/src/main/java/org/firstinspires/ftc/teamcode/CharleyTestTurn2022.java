package org.firstinspires.ftc.teamcode;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.robotcore.external.Telemetry;
@Autonomous(name="CharleyTestTurn2022", group = "FTC")
public class CharleyTestTurn2022 extends LinearOpMode {
    //Create Motors
    DcMotor leftFront;
    DcMotor rightFront;
    DcMotor leftBack;
    DcMotor rightBack;
    DcMotor arm;
    DcMotor blueCarousel;
    DcMotor redCarousel;
    DcMotor tapeMeasure;
    //Create Servo
    CRServo belt;
    //Other creations
    BNO055IMU imu;
    Orientation angles;
    @Override
    public void runOpMode() throws InterruptedException {
        //Connect Motor
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");
        arm = hardwareMap.get(DcMotor.class, "arm");
        blueCarousel = hardwareMap.get(DcMotor.class, "blueCarousel");
        redCarousel = hardwareMap.get(DcMotor.class, "redCarousel");
        tapeMeasure = hardwareMap.get(DcMotor.class, "tapeMeasure");
        //Connect Servo
        belt = hardwareMap.get(CRServo.class, "belt");
        //Set Up Motor Direction
        leftFront.setDirection(DcMotor.Direction.REVERSE);
        rightFront.setDirection(DcMotor.Direction.FORWARD);
        leftBack.setDirection(DcMotor.Direction.REVERSE);
        rightBack.setDirection(DcMotor.Direction.FORWARD);
        //makes it wait to do stuff until it starts
        waitForStart();
        }
    }