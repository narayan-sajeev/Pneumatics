package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * This is an implementation of the Compressor for Alfred.
 *
 * <p>The compressor wasn't made as a subsystem in previous years, but it is the cleanest way to
 * manage it.
 *
 * <p>The compressors job is to fill up the air outside of a match.
 *
 * <p>This one is controlled through smart dashboard, but can also be called directly.
 */
public class CompressorSubsystem extends SubsystemBase {

  private boolean enabled = false;

  // Compressor object
  private final Compressor compressor;

  // Init Compressor
  public CompressorSubsystem() {
    compressor = new Compressor(PneumaticsModuleType.CTREPCM);
  }

  // Update compressor with value
  @Override
  public void periodic() {

    if (compressor.isEnabled() != enabled) {
      if (enabled) {
        compressor.enableDigital();
      } else {
        compressor.disable();
      }
    }
  }

  // Control the compressor
  public void start() {
    enabled = true;
  }

  public void stop() {
    enabled = false;
  }
}
