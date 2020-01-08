
# Thread concepts
 - Threads can be created using Thread t = new Thread(<Runnable inst>) or Thread t = new <SimpleThread extends Thread>().
   - ```public synchronized void start()```: Causes this thread to begin execution.
   - ``` public void run()```: Starts running thread.
   - ``` public final void join() ```: Waits for this thread to die.
   - ```public final synchronized void join(long millis)```: Waits atmost millis for this thread to die.
   - ```public static native void sleep(long millis)```: Causes the currently executing thread to sleep (temporarily cease
     execution) for the specified number of milliseconds. The thread sleeps with all the resources it owns.
   - ```public static native void yield()```: A hint to the scheduler that the current thread is willing to yield its current  use of a processor. The scheduler is free to ignore this hint.
   - ```Object's wait method``` : Causes the thread to wait unless it is being notified using notify or notifyall. The thread releases all the object monitors it owns. And when it is notified it needs to compete in same way for resources as a new thread.
 
## Synchronization objects 
- https://github.com/eshita19/ThreadPractice/tree/master/src/com/sync/objects
- ### Semaphore:
  - Controls access to shared resource using a counter. 
  - If counter > 0, then thread acquires permit, causes semaphore count to be decremented.
  - Thread can release the access to shared resource by releasing semaphore, cauing the semaphore count to be incremented.
  - Hence Semaphore count determines the number of thread that can access a resource at any one time.
- ### CountDownlatch:
   - Count down latch is initialized with a number. It indicates the number of events which will occur before the latch is released.
   - ```latch.await() //wait for counter to become zero
     ``` latch.countDown() // Decrement the count of countdownlatch```   
  
  

 
 
