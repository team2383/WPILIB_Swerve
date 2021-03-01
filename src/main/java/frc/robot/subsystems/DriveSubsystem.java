// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.TalonSRXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.geometry.Translation2d;
import edu.wpi.first.wpilibj.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.kinematics.SwerveDriveKinematics;
import edu.wpi.first.wpilibj.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import java.util.Arrays;

public class DriveSubsystem extends SubsystemBase {

  //Defining Motor variables and kinematics
  public WPI_TalonFX frontRightDrive, frontLeftDrive, backRightDrive, backLeftDrive;
  public WPI_TalonSRX frontRightTurn, frontLeftTurn, backRightTurn, backLeftTurn;
  SwerveDriveKinematics m_kinematics;

  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
    //Assigning variables to motor objects
    frontRightDrive = new WPI_TalonFX(RobotMap.frontRightDrivePort);
    frontLeftDrive = new WPI_TalonFX(RobotMap.frontLeftDrivePort);
    backRightDrive = new WPI_TalonFX(RobotMap.backRightDrivePort);
    backLeftDrive = new WPI_TalonFX(RobotMap.backLeftDrivePort);
    
    frontRightTurn = new WPI_TalonSRX(RobotMap.frontRightTurnPort);
    frontLeftTurn = new WPI_TalonSRX(RobotMap.frontLeftTurnPort);
    backRightTurn = new WPI_TalonSRX(RobotMap.backRightTurnPort);
    backLeftTurn = new WPI_TalonSRX(RobotMap.backLeftTurnPort);

    Translation2d m_frontLeftLocation = new Translation2d((RobotMap.trackWidth)/2, (RobotMap.trackLength)/2);
    Translation2d m_frontRightLocation = new Translation2d((RobotMap.trackWidth)/2, -(RobotMap.trackLength)/2);
    Translation2d m_backLeftLocation = new Translation2d(-(RobotMap.trackWidth)/2, (RobotMap.trackLength)/2);
    Translation2d m_backRightLocation = new Translation2d(-(RobotMap.trackWidth)/2, -(RobotMap.trackLength)/2);

    m_kinematics = new SwerveDriveKinematics(
                m_frontLeftLocation, m_frontRightLocation, m_backLeftLocation, m_backRightLocation
        );
  }

  public void configDriveControllers(){
    frontRightDrive.setInverted(false);
    frontLeftDrive.setInverted(false);
    backRightDrive.setInverted(false);
    backLeftDrive.setInverted(false);

    frontRightDrive.setSensorPhase(true);
    frontLeftDrive.setSensorPhase(true);
    backRightDrive.setSensorPhase(true);
    backLeftDrive.setSensorPhase(true);
    
    frontRightDrive.setNeutralMode(NeutralMode.Coast);
    frontLeftDrive.setNeutralMode(NeutralMode.Coast);
    backRightDrive.setNeutralMode(NeutralMode.Coast);
    backLeftDrive.setNeutralMode(NeutralMode.Coast);
    
    frontRightDrive.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0, 30);
    frontLeftDrive.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0, 30);
    backRightDrive.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0, 30);
    backLeftDrive.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0, 30);
  }

  public void configTurnControllers(){
    frontRightTurn.setInverted(false);
    frontLeftTurn.setInverted(false);
    backRightTurn.setInverted(false);
    backLeftTurn.setInverted(false);

    frontRightTurn.setSensorPhase(true);
    frontLeftTurn.setSensorPhase(true);
    backRightTurn.setSensorPhase(true);
    backLeftTurn.setSensorPhase(true);
    
    frontRightTurn.setNeutralMode(NeutralMode.Brake);
    frontLeftTurn.setNeutralMode(NeutralMode.Brake);
    backRightTurn.setNeutralMode(NeutralMode.Brake);
    backLeftTurn.setNeutralMode(NeutralMode.Brake);
    
    frontRightTurn.configSelectedFeedbackSensor(TalonSRXFeedbackDevice.CTRE_MagEncoder_Relative, 0, 30);
    frontLeftTurn.configSelectedFeedbackSensor(TalonSRXFeedbackDevice.CTRE_MagEncoder_Relative, 0, 30);
    backRightTurn.configSelectedFeedbackSensor(TalonSRXFeedbackDevice.CTRE_MagEncoder_Relative, 0, 30);
    backLeftTurn.configSelectedFeedbackSensor(TalonSRXFeedbackDevice.CTRE_MagEncoder_Relative, 0, 30);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
