package layout


import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.fragment.app.FragmentActivity




class ViewPager2Adapter(private var mFragmentStateAdapter: FragmentActivity, private var mFragments: ArrayList<Fragment>): FragmentStateAdapter(mFragmentStateAdapter) {
    override fun getItemCount(): Int = mFragments?.size ?: 0
    override fun createFragment(position: Int) = mFragments?.get(position)
}