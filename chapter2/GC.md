Serial GC:
    <开启方式> -XX:+UseSerialGC / -XX:+UseParNewGC
    <GC方式> 针对Young区使用mark-copy算法，针对Old区使用mark-sweep-compact算法。但是不管是针对哪个区都是采用单线程的串行处理，都会触发STW。
    <缺点> 由于采用单线程处理，所以在多核系统中，CPU的利用率不高，每次GC暂停时间较长，所以一般仅适用于内存较小的单核系统中。
    <改进> ParNewGC是针对多核系统改进后的，适用于Young区的串行GC。

Parallel GC: (Java6/7/8的默认GC)
    <开启方式> 针对Young区 -XX:+UserParallelGC / 针对Old区 -XX:+UseParalledOldGC
    <GC方式> 针对Young区使用mark-copy算法，针对Old区使用mark-sweep-compact算法。GC线程默认为CPU的核数，并且在每次GC时，所有CPU都会参与到并行的垃圾清理中。
    <优点> 总的GC暂停时间较短，单次可能较长，但是系统的吞吐量最高，且在两次GC之间，没有任何的GC线程抢占CPU资源。
    <缺点> 由于单次GC暂停时间较长，所以针对内存分配较大的Old区不建议使用并行GC

CMS GC:
    <开启方式> -XX:+UseConcMarkSweepGC
    <GC方式> 其仅适用于针对Old区的垃圾回收，且使用mark-sweep算法，不对内存碎片进行整理，而是使用空闲列表来管理内存空间。其清理过程包括6个阶段：初始标记（有STW）、并发标记、并发预清理、最终标记（有STW）、并发清除、并发重置
    <优点> 默认情况下仅使用1/4的CPU核数（GC线程数等于1/4CPU核数）进行GC处理，可以和应用线程并行，所以没有明显的应用线程的暂停，系统对外的响应效率最高。
    <缺点> 由于不进行Compact工作，所以Old区会存在内存碎片问题，另外在某些情况下，会造成不可预测的暂停时间，特别是堆内存较大的情况下。

G1 GC: (Java9的默认GC)
    <开启方式> -XX:+UseG1GC
    <GC方式> G1GC下不会有固定的Young区和Old区，而是会将堆内存划分为N多小块（通常是2048块），G1 GC不会每次对整个堆空间进行GC，而是以增量的方式，针对垃圾最多的内存块进行优先处理。
    <优点> 由于G1GC会根据一定算法增量的清理每个小的内存块，其GC暂停时间变得可预期可配置，所以非常适合于堆内存较大，同时希望GC暂停时间较短且可控的场景。
    <缺点> 在某些情况，G1 GC触发FullGC时，会导致G1GC退化为Serial GC，导致暂停时间变长。

ZGC: (Java11的默认GC)
    <开启方式> -XX:+UnlockExperimentalVMOptions -XX:+UseZGC
    <优点> GC最大暂停时间可以控制在10ms以内，同时吞吐量相比G1 GC下降不超过15%，支持最大4TB内存，所以非常适合超大内存，且对GC暂停时间有严格限制要求的场景。
    <缺点> 仅支持Linux/64位平台

Shenandoah GC: (Java12的默认GC)
    <开启方式> -XX:+UnlockExperimentalVMOptions -XX:+UseShenandoahGC
    <优点> 可以和应用线程并行处理，最大程度并发，保障最低的GC暂停时间，但是不保证GC最大暂停时间可以控制在10ms以内，所以也适合超大内存，且对GC暂停时间有严格限制要求的场景。

GC策略与堆内存大小的关系：
1）对于Parallel GC: 如果堆内存放置的足够大，由于蓄水池效应，GC次数会减少，但是单次GC暂停时间会变长
2）如果堆内存足够大（4G以上），则建议可以使用G1 GC或者ZGC
3）如果Xmx和Xms设置的不一样大，会导致多次FullGC，从而给系统造成抖动
4）如果出现堆内存上的OOM，建议可以调大Xmx和Xms，或者进行必要的代码优化，解决导致OOM的程序问题
