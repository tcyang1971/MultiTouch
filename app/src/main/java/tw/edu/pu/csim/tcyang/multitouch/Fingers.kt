package tw.edu.pu.csim.tcyang.multitouch

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View

class Fingers(context: Context?) : View(context) {
    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var xPos:Float = 200f
    var yPos:Float = 200f

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(Color.LTGRAY)
        paint.color = Color.YELLOW
        canvas.drawCircle(xPos, yPos, 80f, paint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean{
        xPos = event.getX()
        yPos = event.getY()
        invalidate()
        return true
    }


}
