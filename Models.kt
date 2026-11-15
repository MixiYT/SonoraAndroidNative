package dev.sonora.shared
// Platform-independent presentation contracts. Storage belongs to Rust; transport to the OS player.
data class Song(val id:String,val title:String,val artist:String,val uri:String,val durationMs:Long=0,val cover:String="",val source:String="local",val reference:String=uri,val albumId:String="",val artistIds:List<String> = emptyList())
data class Playback(val songs:List<Song> = emptyList(),val index:Int = -1,val playing:Boolean=false,val positionMs:Long=0,val durationMs:Long=0,val shuffled:Boolean=false,val repeatMode:Int=0) { val current:Song? get()=songs.getOrNull(index) }
data class Library(val songs:List<Song> = emptyList(),val favorites:Set<String> = emptySet(),val accent:Long=0xFF38D9BC)
interface MusicRepository { suspend fun library():Library; suspend fun add(song:Song);suspend fun favorite(id:String):Boolean;suspend fun accent(color:Long) }
