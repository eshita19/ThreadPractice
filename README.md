
# Thread concepts
 - Threads can be created using Thread t = new Thread(<Runnable inst>) or Thread t = new <SimpleThread extends Thread>().
   - ```public synchronized void start()```: Causes this thread to begin execution.
   - ``` public void run()```: Starts running thread.
   - ``` public final void join() ```: Waits for this thread to die.
   - ```public final synchronized void join(long millis)```: Waits atmost millis for this thread to die.
   - ```public static native void sleep(long millis)```: Causes the currently executing thread to sleep (temporarily cease
     execution) for the specified number of milliseconds.
   - ```public static native void yield()```: A hint to the scheduler that the current thread is willing to yield its current  use of a processor. The scheduler is free to ignore this hint.
