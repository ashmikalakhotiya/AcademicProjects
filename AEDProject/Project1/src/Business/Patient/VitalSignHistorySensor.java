package Business.Patient;

import java.util.ArrayList;

/**
 *
 * @author CUTIE
 */
public class VitalSignHistorySensor {

    private ArrayList<VitalSignSensor> history;

    public VitalSignHistorySensor() {
        history = new ArrayList<>();
    }

    public ArrayList<VitalSignSensor> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<VitalSignSensor> history) {
        this.history = history;
    }

    public VitalSignSensor createAndAddVitalSign() {
        VitalSignSensor vitalSign = new VitalSignSensor();
        history.add(vitalSign);
        return vitalSign;
    }

    public void deleteVitalSign(VitalSignSensor vitalSign) {
        history.remove(vitalSign);
    }
}
