              +------------------+
              |    Astronaut     |
              +------------------+
              | - name           |
              | - energy         |
              | - role           |
              +------------------+
              | + performMission()|
              | + canPerform()    |
              | + rest()          |
              +------------------+
                    /  \
                 /       \
         +-------------+   +------------+
         |   Engineer  |   |    Pilot   |
         +-------------+   +------------+
         | - repairSkill|   | - navigationSkill |
         +-------------+   +-------------------+
         | + performMission()| | + performMission()|
         +--------------------+ +-------------------+
                    |
              +------------+
              | Scientist  |
              +------------+
              | - researchLevel |
              +----------------+
              | + performMission()|
              +------------------+

               +--------------+
               |   Mission    |
               +--------------+
               | - name       |
               | - durability |
               | - timeRemaining |
               | - sciencePoints |
               | - priority    |
               +--------------+
               | + isCompleted()|
               +---------------+

               +-----------------+
               |   SpaceState    |
               +-----------------+
               | - score         |
               | - team          |
               +-----------------+
               | + updateScore() |
               +-----------------+

               +----------------+
               |     Team       |
               +----------------+
               | - astronauts[] |
               +----------------+
               | + performMission()|
               | + getTotalSciencePoints()|
               +----------------+
