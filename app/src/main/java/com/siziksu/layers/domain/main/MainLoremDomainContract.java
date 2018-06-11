package com.siziksu.layers.domain.main;

import com.siziksu.layers.domain.model.DateDomainModel;
import com.siziksu.layers.domain.model.LoremIpsumDomainModel;

public interface MainLoremDomainContract {

    void showLoadingDialog();

    void hideLoadingDialog();

    void showError(String message);

    void showLastVisitedDate(DateDomainModel dateDomainModel);

    void showLoremIpsum(LoremIpsumDomainModel loremIpsumDomainModel);
}
