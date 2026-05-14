#include <iostream>
#include <vector>
using std::string, std::cout, std::endl;

class Player {
private:
    string name;

public:
    Player(string name)
        : name(name)
    {
    }
    string getName()
    {
        return name;
    }
};

class Team {
private:
    std::vector<Player*> players;

public:
    void addPlayer(Player* player)
    {
        players.push_back(player);
    }
    std::vector<Player*> getPlayers()
    {
        return players;
    }
};

/*
 * Players can exist even if the team disappears. That's the matter of
 * agregation of objects inside another one.
 */
int main()
{
    Player p1("Messi"),
        p2("someone"),
        p3("Dieter"),
        p4("Someone from celtics");
    Team* team = new Team();
    team->addPlayer(&p1);
    team->addPlayer(&p2);
    team->addPlayer(&p3);
    team->addPlayer(&p4);
    for (Player* player : team->getPlayers()) {
        cout << player->getName() << endl;
    }
    return 0;
}
