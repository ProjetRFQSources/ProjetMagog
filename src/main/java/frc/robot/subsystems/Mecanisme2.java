// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.Mecanisme2Constants;
import frc.robot.Constants.PneumatiqueConstants;

public class Mecanisme2 extends SubsystemBase {

  /** Creates a new ExampleSubsystem. */

  // Definition et declaration du moteur supplementaire et du verin
  //private final VictorSPX m_moteurSupplementaire = new VictorSPX(Mecanisme2Constants.kmoteurSupplementaire);
  private final PWM m_moteurSupplementaire = new PWM(0);

  private final Solenoid m_Verin1 = new Solenoid(0,PneumatiqueConstants.kForward);

  private final Solenoid m_Verin2 = new Solenoid(0,PneumatiqueConstants.kReverse);

  // Creation d'un objet Mecanisme2
  public Mecanisme2() {
    super();
    addChild("Verin", m_Verin1);
    addChild("Verin", m_Verin2);
  }

  @Override
  public void periodic() { // every 20 ms

  }

  // Faire tourner le moteur sens horaire
  // Remarque: le sens de rotation depend du cablage de votre
  // moteur donc il faudra faire un test, une fois votre moteur câblé
  // pour savoir determiner le sens
  public void tourneSensHoraire() {
    //m_moteurSupplementaire.set(ControlMode.PercentOutput, Mecanisme2Constants.kvitesseRotation);
    m_moteurSupplementaire.setSpeed(0.7);
  }
  // Faire tourner le moteur sens anti-horaire
  // Remarque: le sens de rotation depend du cablage de votre
  // moteur donc il faudra faire un test, une fois votre moteur câblé
  // pour savoir determiner le sens
  public void tourneSensAntiHoraire() {
    //m_moteurSupplementaire.set(ControlMode.PercentOutput, -Mecanisme2Constants.kvitesseRotation);
    m_moteurSupplementaire.setSpeed(-0.7);
  }

  // Faire tourner le moteur sens anti-horaire
  // Remarque: le sens de rotation depend du cablage de votre
  // moteur donc il faudra faire un test, une fois votre moteur câblé
  // pour savoir determiner le sens
  public void tourneAnySens(double speed) {
    //m_moteurSupplementaire.set(ControlMode.PercentOutput, -Mecanisme2Constants.kvitesseRotation);
    m_moteurSupplementaire.setSpeed(speed);
  }

  // Mettre le moteur à l'arrêt
  public void mettreAuRepos() {
    //m_moteurSupplementaire.set(ControlMode.PercentOutput, Mecanisme2Constants.krepos);
    m_moteurSupplementaire.setSpeed(0);
    //m_Verin2.set(true);
    retracte1();
  }

  /**
   * Extension du verin
   */
  public void etend1() {
    m_Verin1.set(true);
  }
/**
   * retraction du verin
   */
  public void retracte1() {
    m_Verin1.set(false);
  }
  /**
   * Extension du verin
   */
  public void etend2() {
   // m_Verin2.set(false);
  }

  /**
   * retraction du verin
   */
  public void retracte2() {
   // m_Verin2.set(true);
    
  }

  public void npeumaticOff(){
   // m_Verin2.set(false);
   // m_Verin1.set(false);
  }

}
