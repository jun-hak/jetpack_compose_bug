package layout


import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.fragment.app.FragmentActivity
import com.example.myapplication.ConnectFragment
import com.example.myapplication.GraphFragment


class ViewPager2Adapter(private var mFragmentStateAdapter: FragmentActivity): FragmentStateAdapter(mFragmentStateAdapter) {
    override fun getItemCount(): Int = 2
    override fun createFragment(position: Int) = when(position) {
        0 -> ConnectFragment()
        else -> GraphFragment()
    }
}