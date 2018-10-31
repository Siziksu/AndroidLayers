package com.siziksu.layers.presenter.main;

import com.siziksu.layers.common.function.Action;
import com.siziksu.layers.presenter.BaseViewContract;

public interface MainViewContract extends BaseViewContract {

    void showProgress();

    void hideProgress();

    void showLastVisitedDate(String string);

    void showLoremIpsum(String string);

    void showError(String message);

    void showDialog(int message, int positiveButton, Action positiveAction, int negativeButton, Action negativeAction);
}
