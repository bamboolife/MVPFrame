package com.summary.common.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.summary.common.R;

/**
 * SheetView底部弹窗
 * Created by sundy.jiang on 2018/9/27.
 */
public class UISheetView extends BottomSheetDialogFragment {
    private OnItemClickListener onItemClickListener;
    private View mRootView;
    public static UISheetView newInstance(){
        UISheetView uiSheetView=new UISheetView();
        Bundle args=new Bundle();
        uiSheetView.setArguments(args);
        return uiSheetView;
    }

    /**
     * 绑定回调
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Fragment parent=getParentFragment();
        if (parent!=null){
            onItemClickListener= (OnItemClickListener) parent;
        }else{
            onItemClickListener= (OnItemClickListener) context;
        }
    }

    /**
     * 绑定视图
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView=inflater.inflate(R.layout.sheet_view_item_layout,container,false);
        return mRootView;
    }

    /**
     * 初始化控件
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroy() {
        onItemClickListener=null;
        super.onDestroy();
    }

    /**
     * 列表点击回调
     */
    public interface OnItemClickListener{
        void onItemClicked();
    }
}
