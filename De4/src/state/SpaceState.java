package state;

import team.Team;

public class SpaceState {
    private int score; // Điểm số của đội
    private Team team; // Đội phi hành gia

    // Phương thức để cập nhật trạng thái của vũ trụ và điểm số
    public void updateScore() {
        score = team.getTotalSciencePoints(); // Cập nhật điểm số từ đội
    }

    // Getters và setters
}
