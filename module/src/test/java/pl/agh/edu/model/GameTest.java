package pl.agh.edu.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.common.collect.ImmutableList;

public class GameTest {

	@Test
	public void testToJsonSimpleCase() {
		ImmutableList<Player> players = ImmutableList.of();
		ImmutableList<Plane> planes = ImmutableList.of();
		ImmutableList<Bullet> bullets = ImmutableList.of();
		Game game = new Game(players, planes, bullets, GameState.RUNNING);

		assertEquals("{\"players\":[],\"planes\":[],\"bullets\":[],\"gameState\":\"RUNNING\"}",
				game.toJson().toString());
	}

	@Test
	public void testToJsonWithChildObjects() {
		ImmutableList<Player> players = ImmutableList.of(new Player("bryk",
				678, Team.BLUE));
		ImmutableList<Plane> planes = ImmutableList.of();
		ImmutableList<Bullet> bullets = ImmutableList.of();
		Game game = new Game(players, planes, bullets, GameState.RUNNING);

		assertEquals(
				"{\"players\":[{\"nickName\":\"bryk\",\"points\":678"
		        + ",\"team\":\"BLUE\"}],\"planes\":[],\"bullets\":[],\"gameState\":\"RUNNING\"}",
				game.toJson().toString());
	}
}
