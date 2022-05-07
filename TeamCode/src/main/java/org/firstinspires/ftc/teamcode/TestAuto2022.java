package org.firstinspires.ftc.teamcode;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
@Autonomous(name="TestAuto2022", group = "FTC")
public class TestAuto2022 extends LinearOpMode{
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
        //Other connections
        float error;
        BNO055IMU.Parameters imuParameters;
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        imuParameters = new BNO055IMU.Parameters();
        imuParameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        imuParameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        imuParameters.loggingEnabled = false;
        imu.initialize(imuParameters);
        imu = hardwareMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);
        //Set Up Motor Direction
        leftFront.setDirection(DcMotor.Direction.REVERSE);
        rightFront.setDirection(DcMotor.Direction.FORWARD);
        leftBack.setDirection(DcMotor.Direction.REVERSE);
        rightBack.setDirection(DcMotor.Direction.FORWARD);
        //Set Motors to Use No Power
        leftFront.setPower(0);
        rightFront.setPower(0);
        leftBack.setPower(0);
        rightBack.setPower(0);
        waitForStart();
        leftFront.setPower(0.2);
        rightFront.setPower(0.2);
        leftBack.setPower(0.2);
        rightBack.setPower(0.2);
        sleep(1000);
        error = (float) (angles.firstAngle - 90);
        leftFront.setPower(0.02 * error);
        leftBack.setPower(0.02 * error);
        rightFront.setPower(-0.02 * error);
        rightBack.setPower(-0.02 * error);
        if (Math.abs(error) <= 3) {
            leftFront.setPower(0);
            leftBack.setPower(0);
            rightFront.setPower(0);
            rightBack.setPower(0);
            arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        }
        //public void loop()
    }
}