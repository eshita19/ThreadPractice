
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
  - ```
      Semaphore semaphore = new Semaphore(1);//Initial coount of 1 means semaphore is available for 1 acquisition
      semaphore.acquire() 
      semaphore.release()
     ```
- ### CountDownlatch:
   - Count down latch is initialized with a number. It indicates the number of events which will occur before the latch is released.
     ```
      CountDownLatch latch = new CountDownlatch(3)
      latch.await() //wait for counter to become zero
      latch.countDown() // Decrement the count of countdownlatch. Call it three times to resume execution of thread which called await
      ```
- ### CyclicBarrier: 
   - A synchronization aid that allows a set of threads to all wait for each other to reach a common barrier point. CyclicBarriers are useful in programs involving a fixed sized party of threads that must occasionally wait for each other. The barrier is called <em>cyclic</em> because it can be re-used after the waiting threads are released.
   - ```
     CyclicBarrier barrier = new CyclicBarrier(3);
     barrier.await() // Needs to be called thrice for executing the code further.
     ```
   
- ### Phaser:
  - Phaser allows synchronization of threads which have multiple phases. All the threads will be paused untill a phase of all threads is completed.
  
##  Executors
   - Example: https://github.com/eshita19/ThreadPractice/tree/master/src/com/executor
   - Fixedcachepool - the number of threads in the pool is fixed hence, the threads are re-used once free.
   - SchedulePool - We can schedule the time delay to execute a thread.
   
##  Callable and Future
   - Example : https://github.com/eshita19/ThreadPractice/tree/master/src/com/callable
   -  A class which implements Callable can return a value. The callable object needs to be submitted to executor.
   - The submit operation returns a Future object. Future object get() method call will cause current thread to wait untill th e callable return value is retrieved,

## Locks
  - Example : https://github.com/eshita19/ThreadPractice/tree/master/src/com/locks
  - Lock provides alternative to synchronized methods/blocks. The lock and unlock calls may not be in same method.
  - RentrantLock and ReadWriteLock(multiple reads allowed but single write)
   
##  Atomic Operations
   - Example: https://github.com/eshita19/ThreadPractice/blob/master/src/com/atomic/AtomicOperationsTest.java
   - If the shared resource is a single variable we can use the Atomic version of it. Its method are synchronized.
   - ```get(), getAndSet(val), compareAndSet(expectedval, updateval```
   - Difference between Voltaile and Atomic Integer: https://www.youtube.com/watch?v=WH5UvQJizH0
   
  
  

 
 
