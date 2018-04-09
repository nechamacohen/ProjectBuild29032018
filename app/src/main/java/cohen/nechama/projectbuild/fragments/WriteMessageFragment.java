package cohen.nechama.projectbuild.fragments;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

import cohen.nechama.projectbuild.R;
import cohen.nechama.projectbuild.obj.DAO;
import cohen.nechama.projectbuild.obj.Message;


/**
 * A simple {@link Fragment} subclass.
 */
public class WriteMessageFragment extends Fragment {

    private Spinner spnMessageType;
    private TextView tvDate;
    private Button btnDate;
    private TextView etDetailsMessage;

    public WriteMessageFragment getInstance(Message message) {
        WriteMessageFragment fragment = new WriteMessageFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("Message",message);
        fragment.setArguments(bundle);
        return fragment;
    }

    public WriteMessageFragment getInstance() {
        WriteMessageFragment fragment = new WriteMessageFragment();
        fragment.setArguments(new Bundle());
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_write_message, container, false);
    }

    @Override
    public void onViewCreated(View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);
        spnMessageType = v.findViewById(R.id.spnMessageType);
        tvDate = v.findViewById(R.id.tvDate);
        btnDate = v.findViewById(R.id.btnDate);
        etDetailsMessage = v.findViewById(R.id.etDetailsMessage);


        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        tvDate.setText(year + "/" + (month + 1) + "/" + day);
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });

        Object o = getArguments().getSerializable("Message");
        if(o!=null){
            Message message = (Message) o;
        }
    }



    public void publish(View view) {

        Message message = new Message();
        message.setType(spnMessageType.getSelectedItem().toString());
        message.setDate(tvDate.toString());
        message.setDetailsMessage(etDetailsMessage.toString());


        DAO dao = DAO.getInstance(getContext());
        dao.addMessege(new Message());

    }
}
