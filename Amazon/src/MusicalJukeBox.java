// Design a musical juke box using object oriented principles
// plays music, music controls (play, volume, pause, stop, change song), song list

public class MusicPlayer {

	private class Song {
		private String name;
		private String artist;
		private GENRE genre;
		enum GENRE {
			CLASSIC, RAP, POP, ROCK;
		}
	}

	private ArrayList<Song> songs;
	private int volumeLevel;
	private boolean isPaused;
	private boolean isStopped;
	private int currentSongIndex;

	private static MusicPlayer musicPlayer = null;

	private MusicPlayer() {
		// TODO: fill up songs
		songs = new ArrayList<Song>();
		isPaused = true;
		currentSongIndex = 0;
	}

	public MusicPlayer getMusicPlayer() {
		if (musicPlayer == null)
			musicPlayer = new MusicPlayer();
		return musicPlayer;
	}

	public Song nextSong() {
		if (currentSongIndex >= songs.size())
			currentSongIndex = 0;
		else
			currentSongIndex++;
		return songs.get(currentSongIndex);
	}
	public Song prevSong() {
		if (currentSongIndex == 0)
			currentSongIndex = songs.size()-1;
		else
			currentSongIndex--;
		return songs.get(currentSongIndex);
	}

	public Song play() {
		if (isPaused || isStopped) {
			isPaused = false;
			isStopped = false;
			return songs.get(currentSongIndex);
		}
	}
	public void pause() {
		if (!isPaused) {
			isPaused = true;
			isStopped = false;
		}
	}
	public void stop() {
		if (!isStopped) {
			isPaused = false;
			isStopped = true;
		}
	}
	public int incVolume() {
		return ++volumeLevel;
	}

	public int decVolume() {
		return --volumeLevel;
	}

}