package net.elbaroudy.recyclerviewsample;

import java.util.List;

interface NetworkCallback {
    void onSuccess(List<Something> somethingList);
}
