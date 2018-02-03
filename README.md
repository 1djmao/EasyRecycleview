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

1. BaseViewHolder
    
    viewholder 基于 BaseViewHolder 实现，直接在 ViweHolder 的构造方法中设置布局文件，不用在 RecycleView 中重新设置。示例

```
public class TTViewHolder extends BaseViewHolder {

    TextView mTextView1;
    TextView mTextView2;

    public TTViewHolder(ViewGroup view) {
        super(view, R.layout.item_tt);
        mTextView1=itemView.findViewById(R.id.tt1);
        mTextView2=itemView.findViewById(R.id.tt2);
    }
}
```



2. EasyAdapter

    继承 EasyAdapter 需要设置数据类型泛型；需要实现 onCreateEasyViewHolder 和 onBindEasyViewHolder 两个方法，实现跟普通 Adapter 相同。示例
```
public class MyAdapter extends EasyAdapter<String> {

    public MyAdapter(Context context, List<String> list) {
        super(context, list);
    }

    @Override
    public BaseViewHolder onCreateEasyViewHolder(ViewGroup parent, int viewType) {
        return new TTViewHolder(parent);
    }

    @Override
    public void onBindEasyViewHolder(BaseViewHolder holder, int position) {
        TTViewHolder ttViewHolder= (TTViewHolder) holder;
        ttViewHolder.mTextView1.setText(mList.get(position)+"FAJL");
        ttViewHolder.mTextView2.setText(mList.get(position)+"FAJL");
    }
}

```
#### 3. 设置 Item 的点击监听

```
adapter.setOnItemClickListener
adapter.setOnItemLongCilckListener
```


#### 4. TextViewHolder 和 ImgViewHolder
可以直接使用的 ViewHolder，继承自 BaseViewHolder 。

```
new TextViewHolder(recyclerView,"this is header")
new ImgViewHolder(recyclerView,R.drawable.ic_launcher_foreground)
```

#### 5. 设置 EmptyViewHolder，HeaderViewHolder 和 BottomViewHolder 和监听
**注意** ++以下方法必须在 setLayoutManager 方法后调用++。


```
    adapter.setEmptyViewholder
    adapter.setEmptyViewClickListener

    adapter.setHeaderViewHolder
    adapter.setHeaderViewClickListener
        
    adapter.setFooterViewHolder
    adapter.setFooterViewClickListener
```

#### 6. 数据管理

```
        adapter.addData("new");
        adapter.addData("new",3);
        adapter.removeData(3);
        adapter.clear();
```

#### 7. 分割线
未完成
#### 8. SwipeRecycleView
未完成
