# EasyRecycleview
# 简介
打包 Recycleview 的 Adapter，实现一些简单功能：
1. 简化 Adapter 的实现方法
2. Item 的点击监听
3. 可以直接添加 EmptyViewHolder，HeaderViewHolder 和 BottomViewHolder，及其点击监听事件，提供了两个简单实现（包含 TextView 和 ImagView）
4. 提供了添加和删除数据的接口
5. 几种简单分割线的实现
6. 一个支持下拉刷新的扩展 RecyclewView

# 使用

#### 1. 导入

#### 2. EasyAdapter 定义

1. 继承 EasyAdapetr 需要两个泛型：第一个是数据类型，第二个是 ViewHolder
2. 需要实现 onCreateEasyViewHolder 和 onBindEasyViewHolder 两个方法，实现跟普通 Adapter 相同
示例
```
public class MyAdapter extends EasyAdapter<String,MyAdapter.MyViewHolder> {

    public MyAdapter(Context context, List<String> list) {
        super(context, list);
    }

    @Override
    public MyViewHolder onCreateEasyViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_text,parent,false));
    }

    @Override
    public void onBindEasyViewHolder(MyViewHolder holder, int position) {
        holder.mTextView.setText(mList.get(position)+"FAJL");
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView mTextView;
        public MyViewHolder(View itemView) {
            super(itemView);
            mTextView=itemView.findViewById(R.id.mmtext);

        }
    }
}

```
#### 3. 设置 Item 的点击监听

```
adapter.setOnItemClickListener
adapter.setOnItemLongCilckListener
```


#### 4. TextViewHolder 和 ImgViewHolder
可以直接使用的 ViewHolder

```
new TextViewHolder(this,recyclerView,"this is header")
new ImgViewHolder(this,recyclerView,R.drawable.ic_launcher_foreground)
```

#### 5. 设置 EmptyViewHolder，HeaderViewHolder 和 BottomViewHolder 和监听
**注意：**
1. 以下方法必须在 setLayoutManager 方法后调用
2. 如果使用要 GridLayoutManger 请使用 HeaderGridLayoutManager

```
    adapter.setEmptyViewholder
    adapter.setEmptyViewClickListener

    adapter.setHeaderViewHolder
    adapter.setHeaderViewClickListener
        
    adapter.setBottomViewHolder
    adapter.setBottomViewClickListener
```

#### 6. 分割线
未完成
#### 7. SwipeRecycleView
未完成
