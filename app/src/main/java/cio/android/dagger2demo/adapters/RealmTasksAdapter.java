package cio.android.dagger2demo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import butterknife.BindView;
import cio.android.dagger2demo.R;
import cio.android.dagger2demo.models.Task;

import butterknife.ButterKnife;
import io.realm.RealmRecyclerViewAdapter;
import io.realm.RealmResults;

public class RealmTasksAdapter extends RealmRecyclerViewAdapter<Task, RealmTasksAdapter.MyViewHolder> {

    private ITaskItemClickListener clickListener;

    public RealmTasksAdapter(Context context, RealmResults<Task> realmResults, ITaskItemClickListener clickListener) {
        super(realmResults, true);
        this.clickListener = clickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.task_item, viewGroup, false);
        return new MyViewHolder(v, clickListener);
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int position) {
        final Task task = getItem(position);
        viewHolder.taskName.setText(task.getName());
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.task_item_task_name)
        TextView taskName;
        private ITaskItemClickListener clickListener;

        MyViewHolder(View view, ITaskItemClickListener clickListener) {
            super(view);
            this.clickListener = clickListener;
            ButterKnife.bind(this, view);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(clickListener != null) {
                clickListener.onTaskClick(v, getItem(getAdapterPosition()));
            }
        }
    }

    public interface ITaskItemClickListener {
        void onTaskClick(View caller, Task task);
    }
}
