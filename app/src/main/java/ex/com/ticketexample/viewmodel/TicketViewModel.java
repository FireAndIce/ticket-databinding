package ex.com.ticketexample.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;

import org.threeten.bp.LocalDateTime;

import ex.com.ticketexample.model.Ticket;

/* ViewModels are classes. Used to update the UI */
public class TicketViewModel extends ViewModel {

    public Long pnrNo;
    public Integer trainNo;
    public Long transactionId;
    public Ticket.RailQuotas quota;

    public Double ticketFare;
    public Double gstCharge;
    public Double totalFare;

    public String fromStation;
    public String toStation;

    public String schDepDate;
    public String schArrDate;

    public String passFname;
    public String passMname;
    public String passLname;
    public String mobileNo;
    public String passAddress;

    public int adults;
    public int child;

    public MutableLiveData<Boolean> isFareExpanded = new MutableLiveData<>();

    public String getQuota() {
        return quota.name();
    }

    public String getAdults() {
        return String.valueOf(adults);
    }

    public void toggleFare() {
        isFareExpanded.setValue(!isFareExpanded.getValue());
    }


}
