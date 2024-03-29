package fr.utt.classes.model;

/**
 * Enumeration of all the trophys a card can have.
 */
public enum Trophys {
    HighestClub {
        @Override
        int deserveTrophy(Player p) {
            return p.getJest().highestSuit(Suit.Clubs);
        }
    },
    HighestSpade {
        @Override
        int deserveTrophy(Player p) {
            return p.getJest().highestSuit(Suit.Spades);
        }
    },
    HighestHeart {
        @Override
        int deserveTrophy(Player p) {
            return p.getJest().highestSuit(Suit.Hearts);
        }
    },
    HighestDiamond {
        @Override
        int deserveTrophy(Player p) {
            return p.getJest().highestSuit(Suit.Diamonds);
        }
    },
    LowestClub {
        @Override
        int deserveTrophy(Player p) {
            return p.getJest().lowestSuit(Suit.Clubs);
        }
    },
    LowestSpade {
        @Override
        int deserveTrophy(Player p) {
            return p.getJest().lowestSuit(Suit.Spades);
        }
    },
    LowestHeart {
        @Override
        int deserveTrophy(Player p) {
            return p.getJest().lowestSuit(Suit.Hearts);
        }
    },
    LowestDiamond {
        @Override
        int deserveTrophy(Player p) {
            return p.getJest().lowestSuit(Suit.Diamonds);
        }
    },
    MajorityTwo {
        @Override
        int deserveTrophy(Player p) {
            return p.getJest().majority(Kind.Two);
        }
    },
    MajorityThree {
        @Override
        int deserveTrophy(Player p) {
            return p.getJest().majority(Kind.Three);
        }
    },
    MajorityFour {
        @Override
        int deserveTrophy(Player p) {
            return p.getJest().majority(Kind.Four);
        }
    },
    Joker {
        @Override
        int deserveTrophy(Player p) {
            if (p.getJest().hasJoker()) {
                return 10;
            }
            return 0;
        }
    },
    BestJest {
        @Override
        int deserveTrophy(Player p) {
            return p.getScore().getScore();
        }
    },
    BJnoJoke {
        @Override
        int deserveTrophy(Player p) {
            if (p.getJest().hasJoker() == false) {
                return p.getScore().getScore();
            }
            return 0;
        }
    },
    None {
        @Override
        int deserveTrophy(Player p) {
            return 0;
        }
    };

    /**
     * Deserves the trophy to the right player, who wins this trophy according to its jest.
     *
     * @param p PLayer concerned by the trophy
     * @return int value of the trophy
     */
    abstract int deserveTrophy(Player p);
}
