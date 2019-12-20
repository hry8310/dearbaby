   <strong>为什么叫 dearbaby：</strong>
  <p>dearbaby 的取名主要有两个方面，
  <ul style='margin-left:60px;'>
   <li>(1) dearbaby 的sql解析模块是抄derby的。所以取名时是在derby的名称上添加个别字母而定，</li>
   <li>(2) 项目花费了很多本来是用来陪孩子的时间，所以取名dearbaby，也是希望那些加班的IT男能够有更多的时间陪伴家人</li>
   </ul>。
   </p>
   <strong>dearbaby 是什么：</strong>
   <p>dearbaby 这是跨数据库一个 select 查询语句连接器。
   通过该工具可以将连接查询分割成多个单表查询，再将单表结果集进行连接，
   即将数据库的连接功能上移到工具执行。主要用于解决分布式数据库跨库查询的处理.它有哪些特点：
   <ul style='margin-left:60px;'>
   <li>使用derby的sql解析模块，并在此基础上进行修改的（derby 是一款java 实现的数据库，有兴趣可以度娘一下）</li>
   <li>以API的方式提供调用。例子请参考源码的 org.apache.dearbaby.join.DearTest </li>
   <li>dearbaby只是一个工具包，不是分库的proxy server。对于dearbaby。他只能面向一个数据库（或一个数据库集群的proxy server）的唯一入口</li>
   <li>通常，被应用作为工具包引入，再使用如JDBC的方式访问数据库集群 </li>
   </ul>
   </p>
   
   <p>
   <strong>它的原理是：</strong><br/> 
   在分库的环境下, TAB1、TAB2 的数据分布在多个节点下，如执行：select A.a,B.b from TAB1 A, TAB2 B whre A.id=b.id。
   是不能将这个语句直接放在数据库运行的
   而需要将TAB1与TAB2的记录集分别查询，再在应用中将这两个表的记录集进行等值连接。dearbaby 就是实现这个功能的。他将
   select A.a,B.b from TAB1 A, TAB2 B whre A.id=b.id 分拆成 select A.a,A.id from TAB1 A 与 select B.b,B.id from TAB1 B。再
   分别执行这两个语句。得到TAB1与TAB2的查询结果，最后将两个结果集按 A.id=b.id 的条件连接。dearbaby 就是以API的方式提供该功能，
   解决应用中的需求
   </p>
   
   <br/><br/> 
   <strong>支持那些语法：</strong>
   <li>支持多表间的全连接、左右连接，支持=、>=、<=、<>,null等逻辑运算。支持in,not in,like,not like子查询(like 只支持 _ % 匹配)。</li>
   <li>支持max\sum\min\count 聚合函数,支持group by 分组。由于order by 很耗内存，建议不要使用</li>
   <li>支持from 、jion、字段等部分包含子查询,支持嵌套子查询，支持关联的子查询，但目前测试并不全面</li>
   <br/><br/> 
   <strong>有哪些限制：</strong>
   <li>不支持带 * 的sql语句。如： select * from a , select count(*) from a 等都不支持</li>
   <li> sql中的表都必须加上别名。如 select aid,bname from taba,tablb where aid=bid 必须改为 select a.aid  , b.bname   from taba a,tablb b where a.aid=b.bid </li>
   <li>like的使用有限制，支持 _ % 匹配</li>
   <li>不支持exist，而由于order by 会比较占用内存，将也不再支持</li>
   <br/><br/> 
   <strong>做了那些优化（详情可见 <a href='https://github.com/hry8310/derbymi/wiki/%E4%BC%98%E5%8C%96%E8%BF%87%E7%A8%8B%E5%88%86%E4%BA%AB'>《优化过程分享》</a>）：</strong>
    <ul style='margin-left:60px;'>
   <li>支持hash连接（等值连接）、排序连接（大于、小于等非等值连接），引入hash连接后，性能提交100倍</li>
   <li>支持内存压缩，将记录集系列化成线性内存，内存比纯对象形式保存节省超过一半空间</li>
   <li>支持将记录集从内存置换到硬盘，实现用时间换空间</li>
   <li>支持将记录集缓存到本地硬盘，减少对数据库的访问，适用一些数据变动较少的数据表，如流水历史表之类的表数据</li>
   <li>使用直接内存保存记录集，避免老年区撑爆、避开jvm的GC，按需自己管理内存</li>
   <li>实现了并发与串行化的转换，当内存的使用量达到阈值时，多个同时进行的连接将会转为串化等待</li>
   <li>支持单条sql的并发连接</li>
   </ul>

