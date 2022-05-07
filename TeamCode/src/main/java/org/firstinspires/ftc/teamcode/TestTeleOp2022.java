package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
@TeleOp(name="TestTeleOp2022")
public class TestTeleOp2022 extends OpMode{
    //Create Motors
    public DcMotor leftFront = null;
    public DcMotor rightFront = null;
    public DcMotor leftBack = null;
    public DcMotor rightBack = null;
    public DcMotor arm = null;
    public DcMotor blueCarousel = null;
    public DcMotor redCarousel = null;
    public DcMotor tapeMeasure = null;
    //Create Servos
    public CRServo belt = null;
    //Additional Variables
    public ElapsedTime runtime = new ElapsedTime(2);
    @Override
    public void init() {
        //Connect Motor
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");
        arm = hardwareMap.get(DcMotor.class, "arm");
        blueCarousel = hardwareMap.get(DcMotor.class, "blueCarousel");
        redCarousel = hardwareMap.get(DcMotor.class, "redCarousel");
        tapeMeasure = hardwareMap.get(DcMotor.class, "tapeMeasure");
        belt = hardwareMap.get(CRServo.class, "belt");
        //Connect Servo
        //Set Up Motor Direction
        leftFront.setDirection(DcMotor.Direction.REVERSE);
        rightFront.setDirection(DcMotor.Direction.FORWARD);
        leftBack.setDirection(DcMotor.Direction.REVERSE);
        rightBack.setDirection(DcMotor.Direction.FORWARD);
        //Set Motor Mode
        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //Set ZERO POWER BEHAVIOR
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    @Override
    public void start() {
    }
    @Override
    public void loop() {
        if (gamepad1.dpad_up) {
            leftFront.setPower(0.5);
            rightFront.setPower(0.5);
            leftBack.setPower(0.5);
            rightBack.setPower(0.5);
        } else if (gamepad1.dpad_down) {
            leftFront.setPower(-0.5);
            rightFront.setPower(-0.5);
            leftBack.setPower(-0.5);
            rightBack.setPower(-0.5);
        } else if (gamepad1.dpad_left) {
            leftFront.setPower(0.5);
            rightFront.setPower(0.5);
            leftBack.setPower(-0.5);
            rightBack.setPower(-0.5);
        } else if (gamepad1.dpad_right) {
            leftFront.setPower(-0.5);
            rightFront.setPower(-0.5);
            leftBack.setPower(0.5);
            rightBack.setPower(0.5);
        } else if (gamepad1.left_bumper) {
            leftFront.setPower(-0.5);
            rightFront.setPower(0.5);
            leftBack.setPower(-0.5);
            rightBack.setPower(0.5);
        } else if (gamepad1.right_bumper) {
            leftFront.setPower(0.5);
            rightFront.setPower(-0.5);
            leftBack.setPower(0.5);
            rightBack.setPower(-0.5);
        } else if (gamepad1.a) {
            tapeMeasure.setPower(-0.5);
        } else if (gamepad1.b) {
            redCarousel.setPower(-0.5);
        } else if (gamepad1.x) {
            blueCarousel.setPower(0.5);
        } else if (gamepad1.y) {
            tapeMeasure.setPower(0.5);
        } else {
            tapeMeasure.setPower(0);
            redCarousel.setPower(0);
            blueCarousel.setPower(0);
            tapeMeasure.setPower(0);
        }
        if (gamepad2.dpad_down){
            arm.setPower(0.8);
        } else if (gamepad2.dpad_up) {
            arm.setPower(-0.8);
        } else if (gamepad2.y) {
            belt.setPower(0.5);
        } else if (gamepad2.a) {
            belt.setPower(-0.5);
        } else {
            arm.setPower(0);
            belt.setPower(0);
        }
        leftFront.setPower(-gamepad1.left_stick_y + gamepad1.left_trigger + -gamepad1.right_trigger);
        leftBack.setPower(-gamepad1.left_stick_y + -gamepad1.left_trigger + gamepad1.right_trigger);
        rightFront.setPower(-gamepad1.right_stick_y + gamepad1.left_trigger + -gamepad1.right_trigger);
        rightBack.setPower(-gamepad1.right_stick_y + -gamepad1.left_trigger + gamepad1.right_trigger);
    }
}