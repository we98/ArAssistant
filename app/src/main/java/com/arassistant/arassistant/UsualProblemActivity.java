package com.arassistant.arassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

public class UsualProblemActivity extends AppCompatActivity {

    private ExpandableListView usualProblemList;
    private MyExpandableListAdapter myExpandableListAdapter = new MyExpandableListAdapter();

    private String[] groups = {"操作机器", "制作咖啡"};
    private String[][] childs = {
            {"开启机器", "关闭机器", "设置自动关机"},
            {"选择咖啡口味浓淡", "选择咖啡杯量", "选择咖啡研磨程度", "使用咖啡粉制作咖啡", "使用咖啡豆制作咖啡"},
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usual_problem);
        usualProblemList = findViewById(R.id.usualProblemList);
        usualProblemList.setAdapter(myExpandableListAdapter);
        usualProblemList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                Intent intent = new Intent(UsualProblemActivity.this, OperationListActivity.class);
                startActivity(intent);
                return true;
            }
        });
    }


    /**
     * 内部类
     * 用于为ExpandableListView设置数据源
     */
    class MyExpandableListAdapter extends BaseExpandableListAdapter{
        @Override
        public int getGroupCount() {
            return groups.length;
        }
        @Override
        public int getChildrenCount(int i) {
            return childs[i].length;
        }

        /**
         * 返回一级列表的单个item
         * 返回的是对象
         * @param i
         * @return
         */
        @Override
        public Object getGroup(int i) {
            return groups[i];
        }

        /**
         * 返回二级列表中的单个item
         * 返回的是对象
         * @param i
         * @param i1
         * @return
         */
        @Override
        public Object getChild(int i, int i1) {
            return childs[i][i1];
        }

        @Override
        public long getGroupId(int i) {
            return 0;
        }

        @Override
        public long getChildId(int i, int i1) {
            return 0;
        }

        /**
         * 每个item的id是否为固定
         * 一般为true
         * @return
         */
        @Override
        public boolean hasStableIds() {
            return true;
        }

        /**
         * 填充一级列表
         * @param i
         * @param b
         * @param view
         * @param viewGroup
         * @return
         */
        @Override
        public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
            if(view == null){
                view = getLayoutInflater().inflate(R.layout.itemgroup_activity_usualproblem, null);
            }
            else{
                System.out.println("========当前一级列表" + i + "的view不为空============");
            }
            TextView textGroup = view.findViewById(R.id.textGroup);
            textGroup.setText(groups[i]);
            return view;
        }

        /**
         * 填充二级列表
         * @param i
         * @param i1
         * @param b
         * @param view
         * @param viewGroup
         * @return
         */
        @Override
        public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
            if(view == null){
                view = getLayoutInflater().inflate(R.layout.itemchild_activity_usualproblem, null);
            }
            else{
                System.out.println("========当前二级列表" + i + "  " + i1 + "的view不为空============");
            }
            TextView textChild = view.findViewById(R.id.textChild);
            textChild.setText(childs[i][i1]);
            return view;
        }

        /**
         * 二级列表中的item是否能够被选中
         * 可以改为true
         * 修改为true之后才能响应点击事件
         *
         * @param i
         * @param i1
         * @return
         */
        @Override
        public boolean isChildSelectable(int i, int i1) {
            return true;
        }
    }

}



