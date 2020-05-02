package Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.getoutpolio.Book;
import com.example.getoutpolio.R;
import com.example.getoutpolio.RecyclerviewAdapter;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    View view;
    List<Book> lstBook;
   private RecyclerView mRecyclerView;
   private Context Context;
GridLayoutManager gridLayoutManager;
RecyclerviewAdapter mAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        mRecyclerView= root.findViewById(R.id.recyclerview_id);
        List<Book> mFlowerList;
        List<Book> lstBook;
        Book mFlowerData;

        GridLayoutManager mGridLayoutManager = new GridLayoutManager(Context,2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        lstBook=new ArrayList<>();
        lstBook.add(new Book("The Title1","category book","descripton book",R.drawable.img1));
        lstBook.add(new Book("The Title2","category book","descripton book",R.drawable.img2));
        lstBook.add(new Book("The Title3","category book","descripton book",R.drawable.img3));
        lstBook.add(new Book("The Title4","category book","descripton book",R.drawable.img4));
        lstBook.add(new Book("The Title5","category book","descripton book",R.drawable.img5));
        lstBook.add(new Book("The Titl6","category book","descripton book",R.drawable.img6));
        lstBook.add(new Book("The Title1","category book","descripton book",R.drawable.img1));
        lstBook.add(new Book("The Title2","category book","descripton book",R.drawable.img2));
        lstBook.add(new Book("The Title3","category book","descripton book",R.drawable.img3));
        lstBook.add(new Book("The Title4","category book","descripton book",R.drawable.img4));
        lstBook.add(new Book("The Title5","category book","descripton book",R.drawable.img5));
        lstBook.add(new Book("The Titl6","category book","descripton book",R.drawable.img6));



        RecyclerviewAdapter myAdapter = new RecyclerviewAdapter(Context,lstBook);
        mRecyclerView.setAdapter(myAdapter);
        return root;




    }
}
