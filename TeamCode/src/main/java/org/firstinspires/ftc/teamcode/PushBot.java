package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;
import com.qualcomm.hardware.bosch.BNO055IMU;
public abstract class PushBot extends LinearOpMode {
    public DcMotor leftFront = null;
    public DcMotor rightFront = null;
    public DcMotor leftBack = null;
    public DcMotor rightBack = null;
    public HardwareMap hwMap = null;
    public BNO055IMU imu;
    private ElapsedTime period = new ElapsedTime();
    @Autonomous(name="PushBot", group = "PushBot")
    public class start {
        HardwarePushbot robot = new HardwarePushbot();
        private ElapsedTime runtime = new ElapsedTime();
        static final double FORWARD_SPEED = 0.5;
        static final double TURN_SPEED = 0.5;
        public void init (HardwareMap ahwMap){
            hwMap = ahwMap;
            leftFront = hwMap.get(DcMotor.class, "leftFront");
            rightFront = hwMap.get(DcMotor.class, "rightFront");
            leftBack = hwMap.get(DcMotor.class, "leftBack");
            rightBack = hwMap.get(DcMotor.class, "rightBack");
            leftFront.setDirection(DcMotor.Direction.REVERSE);
            rightFront.setDirection(DcMotor.Direction.FORWARD);
            leftBack.setDirection(DcMotor.Direction.REVERSE);
            rightBack.setDirection(DcMotor.Direction.FORWARD);
            leftFront.setPower(0);
            rightFront.setPower(0);
            leftBack.setPower(0);
            rightBack.setPower(0);
            waitForStart();
            leftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            rightFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            leftBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            rightBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
        public void runOpMode() throws InterruptedException{
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
            robot.init(hardwareMap);
            telemetry.addData("Status", "Ready to run");
            telemetry.update();
            waitForStart();
            runtime.reset();
            while (opModeIsActive() && runtime.milliseconds() < 5000){
                telemetry.addData("moving forward", "");
                telemetry.update();
            }
            leftFront.setPower(0);
            rightFront.setPower(0);
            leftBack.setPower(0);
            rightBack.setPower(0);
            sleep(1000);
            leftFront.setPower(-TURN_SPEED);
            rightFront.setPower(-TURN_SPEED);
            leftBack.setPower(TURN_SPEED);
            rightBack.setPower(TURN_SPEED);
            runtime.reset();
            while (opModeIsActive() && runtime.milliseconds() < 3000){
                telemetry.addData("turning left", "");
                telemetry.update();
            }
            leftFront.setPower(0);
            rightFront.setPower(0);
            leftBack.setPower(0);
            rightBack.setPower(0);
            sleep(1000);
        }
    }
}