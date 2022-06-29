package com.example.exchangecurrency.ui.view

import android.animation.ObjectAnimator
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.animation.AnticipateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import coil.load
import com.example.exchangecurrency.RoomDB
import com.example.exchangecurrency.app
import com.example.exchangecurrency.data.entities.UnitEx
import com.example.exchangecurrency.databinding.ActivityMainBinding
import com.example.exchangecurrency.ui.viewmodel.MainActivityViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinScopeComponent
import org.koin.core.component.getOrCreateScope
import org.koin.core.component.inject



import org.koin.core.qualifier.named
import org.koin.core.scope.Scope
import kotlin.properties.Delegates
import kotlin.reflect.KProperty


class MainActivity : AppCompatActivity(),KoinScopeComponent {

    //create viewModel
    private val viewModel: MainActivityViewModel by viewModel()


    //create test Scope module
    override val scope: Scope by getOrCreateScope()
    //room
    private val room: RoomDB by inject(named("roomDb"))
    //coroutines
    val cScope = CoroutineScope(Dispatchers.IO)
    var job: Job? = null

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val splashScreen = installSplashScreen()
            splashScreen.setOnExitAnimationListener { splashScreenProvider ->
                ObjectAnimator.ofFloat(
                    splashScreenProvider.view,
                    View.TRANSLATION_Y,
                    0f, -splashScreenProvider.view.height.toFloat()
                ).apply {
                    duration = 500
                    interpolator = AnticipateInterpolator() //occurs with acceleration
                    doOnEnd { splashScreenProvider.remove() }
                }.start()
            }
        }

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //splashScreen(splashScreen) //Splash Screen

        //test new modules (myLibraryTest & myLibraryTest2)
      //  TestObject.sum(1,3)
      //  TestObject.both(2,4)

        binding.buttonExCurrency.setOnClickListener {
            val userData = binding.editText.text.toString().toInt()
            viewModel.getData(userData)//we are requesting data from liveDat

            binding.image.load("https://firebasestorage.googleapis.com/v0/b/fairytale-cc1c4.appspot.com/o/Exchange_simple.png?alt=media&token=e5433cbf-4208-4c7e-9db9-35570f31e27c")
        }

        viewModel.currencyLiveData.observe(this) {
            val amount = it.result
            binding.textViewExBase.text = amount.toString()

            job?.cancel()
            job = cScope.launch {
                val dao = room.getRoom(app).currencyDao()
                dao.insertOneUnit(UnitEx(1, it.result))
                println("VVV ${dao.getAll()}")
            }
        }
//delegate from the Box
        val d = InTheBoxDelegates()
        d.vetoValue = 2
        println("VVV ${d.vetoValue}")
//======================


        val du = DelegatePropUser()
        du.v = "!!!"
        println("VVV ${du.v}")
    }

    override fun onDestroy() {
        scope.closed
        super.onDestroy()
    }
}

fun splashScreen(splashScreen: SplashScreen) {

}

//fun "DelegatePropUser()" delegates some job to do other function "myDelegate()"
class DelegatePropUser{
    var v: String by myDelegate()

}

class Delegate {

    var value = 123
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "VVV $value, thank for delegate '${property.name}'"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, s: String) {
        println("VVV $value has been asigned to '${property.name}' in $thisRef")
    }

}
fun myDelegate() = Delegate()

//======================
class InTheBoxDelegates{
    var vetoValue by Delegates.vetoable(1){
        property, oldValue, newValue ->
        oldValue < newValue
    }
}
//======================
