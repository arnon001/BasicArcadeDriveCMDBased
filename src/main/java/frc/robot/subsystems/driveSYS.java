// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;
import frc.robot.Constants.Ports;

public class driveSYS extends SubsystemBase {
  private final static CANSparkMax m_LeftMaster = new CANSparkMax(Ports.kLeftMaster, MotorType.kBrushless);
  private final static CANSparkMax m_LeftSlave = new CANSparkMax(Ports.kLeftSlave, MotorType.kBrushless);

  private final static CANSparkMax m_RightMaster = new CANSparkMax(Ports.kRightMaster, MotorType.kBrushless);
  private final static CANSparkMax m_RightSlave = new CANSparkMax(Ports.kRightSlave, MotorType.kBrushless);

  private final DifferentialDrive m_robot = new DifferentialDrive(m_LeftMaster, m_RightMaster);
  /** Creates a new driveSYS. */
  public driveSYS() {
    m_LeftSlave.follow(m_LeftMaster);
    m_RightSlave.follow(m_RightMaster);

    m_RightMaster.setInverted(true);
  }

  public void arcadeDrive(double xStick, double yStick) {
    m_robot.arcadeDrive(xStick / OperatorConstants.Speed, yStick / OperatorConstants.Speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
