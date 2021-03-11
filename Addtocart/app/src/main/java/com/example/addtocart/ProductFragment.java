package com.example.addtocart;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;


public class ProductFragment extends Fragment {

    private RecyclerView rcvProduct;
    private View mView;
    private MainActivity mainActivity;
    private ProductAdapter productAdapter;




    public ProductFragment() {
        // Required empty public constructor
    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_product, container, false);
        mainActivity = (MainActivity) getActivity();

        rcvProduct = mView.findViewById(R.id.rcv_product);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mainActivity);
        rcvProduct.setLayoutManager(linearLayoutManager);

        productAdapter = new ProductAdapter();
        productAdapter.setData(getListProduct(), new ProductAdapter.IClickAddToCartListener() {
            @Override
            public void onclickAddToCart(ImageView imgAddToCart, Product product) {
                AnimationUtil.translateAnimation(mainActivity.getViewAnimation(), imgAddToCart, mainActivity.getViewEndAnimation(), new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        product.setAddToCart(true);
                        imgAddToCart.setBackgroundResource(R.drawable.bg_gray_corner_6);
                        productAdapter.notifyDataSetChanged();

                        mainActivity.setCountProductInCart(mainActivity.getCountProduct() + 1);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });

        rcvProduct.setAdapter(productAdapter);

        return mView;
    }

    private List<Product> getListProduct() {
        List<Product> list = new ArrayList<>();
        list.add(new Product(R.drawable.image, "Product_name", "This is description"));
        list.add(new Product(R.drawable.image, "Product_name", "This is description"));
        list.add(new Product(R.drawable.image, "Product_name", "This is description"));
        list.add(new Product(R.drawable.image, "Product_name", "This is description"));
        list.add(new Product(R.drawable.image, "Product_name", "This is description"));
        list.add(new Product(R.drawable.image, "Product_name", "This is description"));
        list.add(new Product(R.drawable.image, "Product_name", "This is description"));
        list.add(new Product(R.drawable.image, "Product_name", "This is description"));
        list.add(new Product(R.drawable.image, "Product_name", "This is description"));
        list.add(new Product(R.drawable.image, "Product_name", "This is description"));
        list.add(new Product(R.drawable.image, "Product_name", "This is description"));




        return list;
    }
}