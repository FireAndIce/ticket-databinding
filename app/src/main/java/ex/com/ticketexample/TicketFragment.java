package ex.com.ticketexample;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.InverseBindingAdapter;
import android.databinding.InverseBindingListener;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.time.LocalDateTime;

import ex.com.ticketexample.databinding.TicketFragmentBinding;
import ex.com.ticketexample.model.Ticket;
import ex.com.ticketexample.viewmodel.TicketViewModel;

public class TicketFragment extends Fragment {
    public static final String TAG = TicketFragment.class.getName();

    // The Model
    private Ticket ticket;

    // The ViewModel
    private TicketViewModel ticketViewModel;

    /* Generated when <layout> is used in ticket_fragment.xml*/
    TicketFragmentBinding mFragBinding;

    public static TicketFragment newInstance() {
        return new TicketFragment();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_menu, menu);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nightmode:

                toggleNightMode(item);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void toggleNightMode(MenuItem item) {
        boolean toggleNightMode = !item.isChecked();
        item.setChecked(toggleNightMode);
        ticketViewModel.nightModeChecked.setValue(toggleNightMode);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mFragBinding = DataBindingUtil.inflate(inflater, R.layout.ticket_fragment, container, false);
//        LifeycleOwner should be set otherwise MutableLiveData wont work
        mFragBinding.setLifecycleOwner(this);

        ticket = createTicket();

        /* Binds ticket (MODEL) to ticketViewModel (VIEWMODEL) */
        bindTicket(ticket);
        return mFragBinding.getRoot();

    }

    /* Binds Ticket to TicketViewModel*/
    private void bindTicket(Ticket ticket) {

        ticketViewModel = ViewModelProviders.of(this).get(TicketViewModel.class);

        bindExpandIcon();

        /* Binding MODEL to VIEWMODEL */
        ticketViewModel.pnrNo = ticket.getPnrNo();
        ticketViewModel.trainNo = ticket.getTrainNo();
        ticketViewModel.transactionId = ticket.getTransactionId();
        ticketViewModel.quota = ticket.getQuota();
        ticketViewModel.ticketFare = ticket.getTicketFare();
        ticketViewModel.gstCharge = ticket.getGstCharge();
//        ticketViewModel.totalFare = ticket                   NOTE THE COMMENT
        ticketViewModel.fromStation = ticket.getFromStation();
        ticketViewModel.toStation = ticket.getToStation();
        ticketViewModel.schArrDate = ticket.getSchArrDate();
        ticketViewModel.schDepDate = ticket.getSchDepDate();

        ticketViewModel.passFname = ticket.getPassFname();
        ticketViewModel.passMname = ticket.getPassMname();
        ticketViewModel.passLname = ticket.getPassLname();

        ticketViewModel.mobileNo = ticket.getMobileNo();
        ticketViewModel.passAddress = ticket.getPassAddress();

        ticketViewModel.adults = ticket.getAdults();
        ticketViewModel.child = ticket.getChild();


//        ticketViewModel.setNightModeChecked(true);

        /* Binding VIEWMODEL to VIEW */
        mFragBinding.setTicket(ticketViewModel);



    }

    /* Binds ExpandIcon with TRUE and sets toggle on it.
    * Without MutableLiveData the EXPAND/COLLAPSE WONT WORK */
    private void bindExpandIcon() {
        ticketViewModel.isFareExpanded = new MutableLiveData<>();
        ticketViewModel.isFareExpanded.setValue(true); //DEFAULT VALUE

        mFragBinding.imageView.setOnClickListener(v -> {
            ticketViewModel.toggleFare();
        });
    }


    private Ticket createTicket() {
        Ticket ticket = new Ticket(Long.valueOf("7841236448"), Integer.valueOf("54237"));
        ticket.setTransactionId(Long.valueOf("78945132456"));
        ticket.setQuota(Ticket.RailQuotas.TATKAL);
        ticket.setTicketFare(Double.valueOf(1925.0));
        ticket.setGstCharge(Double.valueOf(50.0));
        ticket.setTotalFare(ticket.getTicketFare() + ticket.getGstCharge());
        ticket.setFromStation("Surat");
        ticket.setToStation("Delhi");
        ticket.setSchDepDate(LocalDateTime.now());
        ticket.setSchArrDate(LocalDateTime.now().plusDays(1).plusHours(2));

        ticket.setPassFname("Sunny");
        ticket.setPassMname("Mohan");
        ticket.setPassLname("Patel");
        ticket.setMobileNo("9462777655");
        ticket.setPassAddress("Hazira Road, Surat");

        ticket.setAdults(4);
        ticket.setChild(2);

        return ticket;
    }


    @BindingAdapter("totalFareText")
    public static void computeTotalFare(TextView view, TicketViewModel ticketViewModel) {
        Log.d(TAG, "In computeTotalFare()");
        view.setText(String.valueOf(ticketViewModel.getTotalFare()));

    }

    @BindingAdapter("app:nightMode")
    public static void setNightMode(ConstraintLayout view,
                                    MutableLiveData<Boolean> nightModeVal) {
//        nightModeChecked.setValue(!nightModeChecked.getValue());
        Log.d(TAG, "In setNightMode()");

        if (nightModeVal.getValue() == null) {
            nightModeVal.setValue(false);
        }


        if (nightModeVal.getValue())
            view.setBackgroundResource(R.color.nightMode);
        else
            view.setBackgroundResource(R.color.lightGray);
    }

    @InverseBindingAdapter(attribute = "app:nightMode", event = "app:nightModeAttrChanged")
    public static Boolean getNightMode(View view) {
        Log.d(TAG, "In getNightMode()");
        return null;
    }

    @BindingAdapter("app:nightModeAttrChanged")
    public static void setListeners(ConstraintLayout view,
                                    final InverseBindingListener attrChange) {
        Log.d(TAG, "In setListeners()");
    }
}
