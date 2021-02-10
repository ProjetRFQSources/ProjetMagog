// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.Mecanisme2Constants;
import frc.robot.Constants.PneumatiqueConstants;

public class Mecanisme2 extends SubsystemBase {

  /** Creates a new ExampleSubsystem. */

  // Definition et declaration du moteur supplementaire et du verin
  private final VictorSPX m_moteurSupplementaire = new VictorSPX(Mecanisme2Constants.kmoteurSupplementaire);

  private final DoubleSolenoid m_Verin = new DoubleSolenoid(PneumatiqueConstants.kForward,
      PneumatiqueConstants.kReverse);

  // Creation d'un objet Mecanisme2
  public Mecanisme2() {
    super();
    addChild("Verin", m_Verin);
  }

  @Override
  public void periodic() { // every 20 ms

  }

  // Faire tourner le moteur sens horaire
  // Remarque: le sens de rotation depend du cablage de votre
  // moteur donc il faudra faire un test, une fois votre moteur câblé
  // pour savoir determiner le sens
  public void tourneSensHoraire() {
    m_moteurSupplementaire.set(ControlMode.PercentOutput, Mecanisme2Constants.kvitesseRotation);
  }

  // Faire tourner le moteur sens anti-horaire
  // Remarque: le sens de rotation depend du cablage de votre
  // moteur donc il faudra faire un test, une fois votre moteur câblé
  // pour savoir determiner le sens
  public void tourneSensAntiHoraire() {
    m_moteurSupplementaire.set(ControlMode.PercentOutput, -Mecanisme2Constants.kvitesseRotation);
  }

  // Mettre le moteur à l'arrêt
  public void mettreAuRepos() {
    m_moteurSupplementaire.set(ControlMode.PercentOutput, Mecanisme2Constants.krepos);
  }

  /**
   * Extension du verin
   */
  public void etend() {
    m_Verin.set(Value.kForward);
  }

  /**
   * retraction du verin
   */
  public void retracte() {
    m_Verin.set(Value.kReverse);
  }

}
