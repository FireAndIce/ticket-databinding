package ex.com.ticketexample.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.util.Log;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import ex.com.ticketexample.model.Ticket;

/* ViewModels are classes. Used to update the UI */
public class TicketViewModel extends ViewModel {
    public static final String TAG = TicketViewModel.class.getName();

    public Long pnrNo;
    public Integer trainNo;
    public Long transactionId;
    public Ticket.RailQuotas quota;

    public Double ticketFare;
    public Double gstCharge;
    public Double totalFare;

    public String fromStation;
    public String toStation;

    public LocalDateTime schDepDate;
    public LocalDateTime schArrDate;

    public String passFname;
    public String passMname;
    public String passLname;
    public String mobileNo;
    public String passAddress;

    public int adults;
    public int child;

    public MutableLiveData<Boolean> isFareExpanded = new MutableLiveData<>();

    public MutableLiveData<Boolean> nightModeChecked = new MutableLiveData<>();


/*    public MutableLiveData<Boolean> getNightModeChecked() {
        Log.d("TicketViewModel", "In getNightModeChecked()");
        return nightModeChecked;
    }*/

    /*public void setNightModeChecked(Boolean value) {
        Log.d("TicketViewModel", "In setNightModeChecked()");
        nightModeChecked.setValue(value);
    }*/

    public String getQuota() {
        return quota.name();
    }

    public String getSchDepDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm a");
        return schDepDate.format(formatter);
    }

    public String getSchArrDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm a");
        return schArrDate.format(formatter);
    }

    public String getAdults() {
        return String.valueOf(adults);
    }

    public String getChild() {
        return String.valueOf(child);
    }

    public void toggleFare() {
        isFareExpanded.setValue(!isFareExpanded.getValue());
    }

    public Double computeTotalFare() {
        return ticketFare + gstCharge;
    }
/*
    public MutableLiveData<Boolean> getNightModeChecked() {
        return nightModeChecked;
    }

    public void setNightModeChecked(MutableLiveData<Boolean> nightModeChecked) {
        this.nightModeChecked = nightModeChecked;
    }*/

    public MutableLiveData<Boolean> getNightModeChecked() {
        Log.d(TAG, "In getNightModeChecked()");
        return nightModeChecked;
    }

    public void setNightModeChecked(Boolean nightModeChecked) {
        Log.d(TAG, "In setNightModeChecked()");
        this.nightModeChecked.setValue(nightModeChecked);
    }
}
