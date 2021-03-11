package com.example.addtocart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{

    private List<Product> mListProduct;
    private IClickAddToCartListener iClickAddToCartListener;

    public interface IClickAddToCartListener {
        void onclickAddToCart(ImageView imgAddToCart, Product product);
    }

    public void setData (List<Product> list, IClickAddToCartListener listener) {
        this.mListProduct = list;
        this.iClickAddToCartListener = listener;
        notifyDataSetChanged();

    }


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = mListProduct.get(position);
        if (product == null){
            return;
        }
        holder.imgProduct.setImageResource(product.getResourceId());
        holder.tvProductName.setText(product.getName());
        holder.tvDescription.setText(product.getDescription());
        if (product.isAddToCart()) {
            holder.imgAddToCart.setBackgroundResource(R.drawable.bg_gray_corner_6);
        } else {
            holder.imgAddToCart.setBackgroundResource(R.drawable.bg_red_corner_6);
        }


        holder.imgAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!product.isAddToCart()){
                    iClickAddToCartListener.onclickAddToCart(holder.imgAddToCart, product);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        if (mListProduct != null){
            return mListProduct.size();
        }
        return 0;
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgProduct;
        private TextView tvProductName;
        private TextView tvDescription;
        private ImageView imgAddToCart;

        public ProductViewHolder(@NonNull View itemview){
            super(itemview);

            imgProduct = itemview.findViewById(R.id.img_product);
            tvProductName = itemview.findViewById(R.id.tv_product_name);
            tvDescription = itemview.findViewById(R.id.tv_description);
            imgAddToCart = itemview.findViewById(R.id.img_add_to_cart);

        }

    }
}
