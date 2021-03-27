package tw.edu.pu.csim.tcyang.multitouch

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View

class Fingers(context: Context) : View(context) {
    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    //var xPos:Float = 200f
    //var yPos:Float = 200f

    var Count:Int = 0;
    var xPos = FloatArray(20)
    var yPos = FloatArray(20)

    var rainbow = IntArray(7)

    init {
        rainbow = context.getResources().getIntArray(R.array.rainbow)
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(Color.LTGRAY)
        paint.color = Color.YELLOW

        for (i in 0..Count-1) {
            //paint.color = Color.YELLOW
            paint.color =rainbow[i % 7]
            canvas.drawCircle(xPos[i], yPos[i], 80f, paint)
        }
        paint.color = Color.BLUE
        paint.textSize = 50f
        canvas.drawText("多指觸控，圓形呈現彩虹顏色！", 50f,200f, paint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean{
        //xPos = event.getX()
        //yPos = event.getY()

        Count = event.getPointerCount()
        for (i in 0..Count-1) {
            xPos[i] = event.getX(i)
            yPos[i] = event.getY(i)
        }

        invalidate()
        return true
    }


}
